package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.PersonException;


import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
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
    public Teacher getById(int id){

        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM teacher WHERE id_teacher = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
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
        int id_teacher=0;
        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT MAX(id_teacher) FROM teacher");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_teacher = rs.getInt(1);
                rs.close();
                return id_teacher;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return id_teacher;
    }


    @Override
    public Teacher add(Teacher item) {
        int id_teacher=getMaxId()+1;
        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO teacher (id_teacher,teacher_name,teacher_surname,teacher_adress,teacher_username,teacher_password,start_work,end_work) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1,id_teacher);
            stmt.setString(2, item.getFirstName());
            stmt.setString(3, item.getSurname());
            stmt.setString(4, item.getAdress());
            stmt.setString(5, item.getUsername());
            stmt.setString(6, item.getPassword());
            stmt.setString(7,item.getStartWork().toString());
            stmt.setString(8,item.getEndWork().toString());
            stmt.executeUpdate();
            item.setId(id_teacher);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Teacher update(Teacher item) {

        try{
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE teacher SET start_work=?,end_work=? WHERE id_teacher=?");
            stmt.setString(1, item.getStartWork().toString());
            stmt.setString(2,item.getEndWork().toString());
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
        try{
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM teacher WHERE id_teacher = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Teacher> getAll() {


        List<Teacher> teachers = new ArrayList<>();
        try{
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM teacher");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
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
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return teachers;
    }

    @Override
    public Teacher searchTeacherByUsername(String username) {
        return null;
    }
}
