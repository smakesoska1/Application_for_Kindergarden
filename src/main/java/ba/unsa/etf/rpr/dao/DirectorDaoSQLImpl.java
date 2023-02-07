package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Director;
import ba.unsa.etf.rpr.domain.Teacher;

import java.sql.*;
import java.time.LocalTime;
import java.util.List;

public class DirectorDaoSQLImpl extends AbstractDao implements DirectorDao,PersonDao {

    private Connection conn;

    public DirectorDaoSQLImpl() {
        super("director");
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
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE director SET director_name=?,director_surname=?," +
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
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM director WHERE director_username=?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Director director = new Director();
                director.setId(rs.getInt("id_director"));
                director.setFirstName(rs.getString("director_name"));
                director.setSurname(rs.getString("director_surname"));
                director.setAdress(rs.getString("director_adress"));
                director.setUsername(rs.getString("director_username"));
                director.setPassword(rs.getString("director_password"));
                director.setPhoneNumber(rs.getInt("director_phone"));
                rs.close();
                return director;
                    }
                }catch (SQLException e) {
                    System.out.println("Nema tog username");
                    System.out.println(e.getMessage());
                }
                return null;
            }


}
