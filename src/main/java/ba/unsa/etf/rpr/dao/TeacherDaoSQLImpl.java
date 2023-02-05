package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Teacher;


import java.sql.*;
import java.time.LocalTime;
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
