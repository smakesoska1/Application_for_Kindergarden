package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;


import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoSQLImpl extends AbstractDao implements TeacherDao,PersonDao {

    private Connection conn;

    public TeacherDaoSQLImpl() {
        super("teacher");
    }


    @Override
    public Teacher getById(int id) throws KindergardenException {

        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM teacher WHERE id_teacher = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id_teacher"));
                teacher.setFirstName(rs.getString("teacher_name"));
                teacher.setSurname(rs.getString("teacher_surname"));
                teacher.setAdress(rs.getString("teacher_adress"));
                teacher.setUsername(rs.getString("teacher_username"));
                teacher.setPassword(rs.getString("teacher_password"));
                teacher.setStartWork(LocalTime.parse(rs.getString("start_work")));
                teacher.setEndWork(LocalTime.parse(rs.getString("end_work")));
                rs.close();
                return teacher;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage(),e);
        }
    }

    private int getMaxId() throws KindergardenException{
        int id_teacher = 0;
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT MAX(id_teacher) FROM teacher");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                id_teacher = rs.getInt(1);
                rs.close();
                return id_teacher;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage(),e);

        }
        return id_teacher;
    }


    @Override
    public Teacher add(Teacher item) throws KindergardenException {
        int id_teacher = getMaxId() + 1;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO teacher (id_teacher,teacher_name,teacher_surname,teacher_adress,teacher_username,teacher_password,start_work,end_work) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, id_teacher);
            stmt.setString(2, item.getFirstName());
            stmt.setString(3, item.getSurname());
            stmt.setString(4, item.getAdress());
            stmt.setString(5, item.getUsername());
            stmt.setString(6, item.getPassword());
            stmt.setString(7, item.getStartWork().toString());
            stmt.setString(8, item.getEndWork().toString());
            stmt.executeUpdate();
            item.setId(id_teacher);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage(), e);
        }
    }

    @Override
    public Teacher update(Teacher item) throws KindergardenException {

        try {
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE teacher SET start_work=?,end_work=? WHERE id_teacher=?");
            stmt.setString(1, item.getStartWork().toString());
            stmt.setString(2, item.getEndWork().toString());
            stmt.setInt(3, item.getId());
            stmt.executeUpdate();
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage(),e);
        }
    }

    @Override
    public void delete(int id) throws KindergardenException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM teacher WHERE id_teacher = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage(),e);
        }
    }

    @Override
    public List<Teacher> getAll() throws KindergardenException {

        List<Teacher> teachers = new ArrayList<>();
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM teacher");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id_teacher"));
                teacher.setFirstName(rs.getString("teacher_name"));
                teacher.setSurname(rs.getString("teacher_surname"));
                teacher.setAdress(rs.getString("teacher_adress"));
                teacher.setUsername(rs.getString("teacher_username"));
                teacher.setPassword(rs.getString("teacher_password"));
                teacher.setStartWork(LocalTime.parse(rs.getString("start_work")));
                teacher.setEndWork(LocalTime.parse(rs.getString("end_work")));
                teachers.add(teacher);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage());
        }
        return teachers;
    }

    @Override
    public Teacher searchTeacherByUsername(String username) throws KindergardenException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM teacher WHERE teacher_username=?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id_teacher"));
                teacher.setFirstName(rs.getString("teacher_name"));
                teacher.setSurname(rs.getString("teacher_surname"));
                teacher.setAdress(rs.getString("teacher_adress"));
                teacher.setUsername(rs.getString("teacher_username"));
                teacher.setPassword(rs.getString("teacher_password"));
                teacher.setStartWork(LocalTime.parse(rs.getString("start_work")));
                teacher.setEndWork(LocalTime.parse(rs.getString("end_work")));
                rs.close();
                return teacher;
            }
        }catch (SQLException e) {
            System.out.println("Nema tog username");
            throw new KindergardenException(e.getMessage(),e);

        }
    return null;
    }
}
