package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Director;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DirectorDaoSQLImpl implements DirectorDao,PersonDao {

    private Connection conn;

    public DirectorDaoSQLImpl() {
        try {
            this.conn= DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza2", "freedb_sara123", "2AP?Su3RJ2zstx?");
        } catch (SQLException e) {
            System.out.println("Greska u radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Director getById(int id) {
        return null;
    }

    @Override
    public Director add(Director item) {
        return null;
    }

    @Override
    public Director update(Director item) {
        try{
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE director SET director_name=?,director_surname=?," +
                    "director_adress=?,director_username=?,director_password=?,director_phone=? WHERE id_director=?");
            stmt.setString(1, item.getFirstName());
            stmt.setString(2,item.getSurname());
            stmt.setString(3, item.getAdress());
            stmt.setString(4,item.getUsername());
            stmt.setString(5,item.getPassword());
            stmt.setInt(6,item.getPhoneNumber());
            stmt.setInt(7,item.getId());
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
    public List<Director> getAll() {
        return null;
    }

    @Override
    public Director searchDirectorByUsername(String username) {
        return null;
    }
}
