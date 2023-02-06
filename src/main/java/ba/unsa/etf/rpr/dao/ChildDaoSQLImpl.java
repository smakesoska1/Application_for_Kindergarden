package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.Parent;


import java.sql.*;
import java.time.LocalTime;
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
    public Child getById(int id){
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM child WHERE id_child = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Child child=new Child();
                child.setId(rs.getInt("id_child"));
                child.setFirstName(rs.getString("child_name"));
                child.setSurname(rs.getString("child_surname"));
                child.setAdress(rs.getString("child_adress"));
                child.setParent(new ParentDaoSQLImpl().getById(rs.getInt("parent_id")));
                child.setTeacher(new TeacherDaoSQLImpl().getById(rs.getInt("teacher_id")));
                child.setStartTime(LocalTime.parse(rs.getString("start_time")));
                child.setEndTime(LocalTime.parse(rs.getString("end_time")));
                child.setActivity(new ActivityDaoSQLImpl().getById(rs.getInt("activity_id")));
                child.setChildNotes(new ChildNotesDaoSQLImpl().getById(rs.getInt("child_notes_id")));
                return child;
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
        int id_child=0;
        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT MAX(id_child) FROM child");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_child = rs.getInt(1);
                rs.close();
                return id_child;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return id_child;
    }


    @Override
    public Child add(Child item) {
        int id_child=getMaxId()+1;
        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO child (id_child,child_name, child_surname, child_adress, parent_id, teacher_id, start_time, end_time, activity_id, child_notes_id) values (?,?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,id_child);
            stmt.setString(2, item.getFirstName());
            stmt.setString(3, item.getSurname());
            stmt.setString(4, item.getAdress());
            stmt.setInt(5, item.getParent().getId());
            stmt.setInt(6, item.getTeacher().getId());
            stmt.setString(7,item.getStartTime().toString());
            stmt.setString(8,item.getEndTime().toString());
            stmt.setInt(9, item.getActivity().getId());
            stmt.setInt(10, item.getChildNotes().getId());
            stmt.executeUpdate();
            item.setId(id_child);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
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
