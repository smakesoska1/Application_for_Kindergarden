package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Director;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL implementation of the DAO
 */

public class ParentDaoSQLImpl extends AbstractDao implements ParentDao,PersonDao{

    private Connection conn;

    /**
     * constructor of ParentDaoSQLImplementation
     */

   public ParentDaoSQLImpl() {
       super("parent");
   }

    /**
     * get parent from database base on ID
     * @param -id primary key of parent
     * @return parent from database
     */
    @Override
    public Parent getById(int id) throws KindergardenException {

        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM parent WHERE id_parent = ?");
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
         throw new KindergardenException(e.getMessage(),e);
        }
    }


    private int getMaxId() throws KindergardenException{
        int id_parent=0;
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT MAX(id_parent) FROM parent");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_parent = rs.getInt(1);
                rs.close();
                return id_parent;
            }
        } catch (SQLException e) {
            throw new KindergardenException(e.getMessage(),e);
        }
        return id_parent;
    }

    /**
     * Saves parent into database
     * @param -parent bean for saving to database
     * @return saved parent with id field
     */
    @Override
    public Parent add(Parent item) throws KindergardenException {
        int id_parent=getMaxId()+1;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO parent (id_parent,parent_name,parent_surname,parent_adress,parent_username,parent_password,parent_phone) VALUES (?,?,?,?,?,?,?)");
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
            throw new KindergardenException(e.getMessage(),e);
        }
    }

    /**
     * updates parent's phone and address in database based on id match.
     * @param -parent item bean to be updated.
     * @return updated version of bean parent
     */
    @Override
    public Parent update(Parent item) throws KindergardenException {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE parent SET parent_adress=?,parent_phone=? WHERE id_parent=?");
            stmt.setString(1, item.getAdress());
            stmt.setInt(2, item.getPhoneNumber());
            stmt.setInt(3,item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
           throw new KindergardenException(e.getMessage(),e);
        }
    }

    /**
     * Delete of item parent from database with given id
     * @param id - primary key of parent
     */
    @Override
    public void delete(int id) throws KindergardenException {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM parent WHERE id_parent = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka.Mora se obrisati prvo dijete.");
            throw new KindergardenException(e.getMessage(),e);
        }
    }

    /**
     * Lists all parents from database.
     * @return List of all parents from database
     */

    @Override
    public List<Parent> getAll() throws KindergardenException {
        List<Parent> parents = new ArrayList<>();
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM parent");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Parent parent = new Parent();
                parent.setId(rs.getInt("id_parent"));
                parent.setFirstName(rs.getString("parent_name"));
                parent.setSurname(rs.getString("parent_surname"));
                parent.setAdress(rs.getString("parent_adress"));
                parent.setUsername(rs.getString("parent_username"));
                parent.setPassword(rs.getString("parent_password"));
                parent.setPhoneNumber(rs.getInt("parent_phone"));
                parents.add(parent);
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage(),e);
        }
        return parents;
    }

    /**
     * Returns parent that is found based on username.
     *
     * @param -username
     * @return parent
     */
    @Override
    public Parent searchParentByUsername(String username) throws KindergardenException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM parent WHERE parent_username=?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
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
            }
        }catch (SQLException e) {
            System.out.println("Nema tog username");
           throw new KindergardenException(e.getMessage(),e);
        }
        return null;
    }
}
