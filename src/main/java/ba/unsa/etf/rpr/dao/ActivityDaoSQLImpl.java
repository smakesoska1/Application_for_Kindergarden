package ba.unsa.etf.rpr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ActivityDaoSQLImpl implements ActivityDao{

    private Connection conn;

    public ActivityDaoSQLImpl() {
        try {
            this.conn= DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza2", "freedb_sara123", "2AP?Su3RJ2zstx?");
        } catch (SQLException e) {
            System.out.println("Greska u radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }
    @Override
    public ActivityDao getById(int id) {
        return null;
    }

    @Override
    public ActivityDao add(ActivityDao item) {
        return null;
    }

    @Override
    public ActivityDao update(ActivityDao item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ActivityDao> getAll() {
        return null;
    }
}
