package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.ChildNotes;
import ba.unsa.etf.rpr.domain.Parent;

import java.sql.*;
import java.util.List;

public class ParentDaoSQLImpl implements ParentDao,PersonDao{

    private Connection conn;

    public ParentDaoSQLImpl() {
        try {
            this.conn= DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza2", "freedb_sara123", "2AP?Su3RJ2zstx?");
        } catch (SQLException e) {
            System.out.println("Greska u radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Parent getById(int id) {

        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM parent WHERE id_parent = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Parent parent = new Parent();
                parent.setId(rs.getInt("id_parent"));
                parent.setFirstName(rs.getString("parent_name"));
                parent.setSurname(rs.getString("parent_surname"));
                parent.setAdress(rs.getString("parent_adress"));
                parent.setUsername(rs.getString("parent_username"));
                parent.setPassword(rs.getString("parent_password"));
                parent.setPhoneNumber(rs.getInt("parent_phone"));
                rs.close();
                return parent;
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }


    private int getMaxId(){
        int id_parent=0;
        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT MAX(id_parent) FROM parent");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_parent = rs.getInt(1);
                rs.close();
                return id_parent;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return id_parent;
    }


    @Override
    public Parent add(Parent item) {
        int id_parent=getMaxId()+1;
        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO parent (id_parent,parent_name,parent_surname,parent_adress,parent_username,parent_password,parent_phone) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1,id_parent);
            stmt.setString(2, item.getFirstName());
            stmt.setString(3, item.getSurname());
            stmt.setString(4, item.getAdress());
            stmt.setString(5, item.getUsername());
            stmt.setString(6, item.getPassword());
            stmt.setInt(7,item.getPhoneNumber());
            stmt.executeUpdate();
            item.setId(id_parent);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Parent update(Parent item) {
        try{
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE parent SET parent_adress=?,parent_phone=? WHERE id_parent=?");
            stmt.setString(1, item.getAdress());
            stmt.setInt(2, item.getPhoneNumber());
            stmt.setInt(3,item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Parent> getAll() {
        return null;
    }
}
