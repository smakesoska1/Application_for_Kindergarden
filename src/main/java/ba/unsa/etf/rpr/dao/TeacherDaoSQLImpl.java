package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TeacherDaoSQLImpl implements TeacherDao,PersonDao{

    private Connection conn;

    public TeacherDaoSQLImpl() {
        try {
            this.conn= DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza2", "freedb_sara123", "2AP?Su3RJ2zstx?");
        } catch (SQLException e) {
            System.out.println("Greska u radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }


    @Override
    public Teacher getById(int id) {
        return null;
    }

    @Override
    public Teacher add(Teacher item) {
        return null;
    }

    @Override
    public Teacher update(Teacher item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Teacher> getAll() {
        return null;
    }
}
