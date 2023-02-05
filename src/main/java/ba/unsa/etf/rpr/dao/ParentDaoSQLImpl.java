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


    @Override
    public Parent add(Parent item) {
        return null;
    }

    @Override
    public Parent update(Parent item) {
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
