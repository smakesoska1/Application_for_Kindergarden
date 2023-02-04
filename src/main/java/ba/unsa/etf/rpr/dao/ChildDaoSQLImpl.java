package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Child;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ChildDaoSQLImpl implements ChildDao{

    private Connection conn;

    public ChildDaoSQLImpl() {
        try {
            this.conn= DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza2", "freedb_sara123", "2AP?Su3RJ2zstx?");
        } catch (SQLException e) {
            System.out.println("Greska u radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Child getById(int id) {
        return null;
    }

    @Override
    public Child add(Child item) {
        return null;
    }

    @Override
    public Child update(Child item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Child> getAll() {
        return null;
    }
}
