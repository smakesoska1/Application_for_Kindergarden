package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.exceptions.KindergardenException;


import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL implementation of the DAO
 */

public class ChildDaoSQLImpl extends AbstractDao implements ChildDao{

    private Connection conn;
    /**
     * construct of ChildDaoSQLImplementation
     */
    public ChildDaoSQLImpl() {
        super("child");
    }

    /**
     * get child from database base on ID
     * @param -id primary key of child
     * @return child from database
     */
    @Override
    public Child getById(int id) throws KindergardenException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM child WHERE id_child = ?");
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
            System.out.println("Kindergarten");
            throw new KindergardenException(e.getMessage());
        }
    }

    private int getMaxId() throws KindergardenException{
        int id_child=0;
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT MAX(id_child) FROM child");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_child = rs.getInt(1);
                rs.close();
                return id_child;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage());
        }
        return id_child;
    }

    /**
     * Saves child into database
     * @param -child bean for saving to database
     * @return saved child with id field populated
     */
    @Override
    public Child add(Child item) throws KindergardenException{
        int id_child=getMaxId()+1;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO child (id_child,child_name, child_surname, child_adress, parent_id, teacher_id, start_time, end_time, activity_id, child_notes_id) values (?,?,?,?,?,?,?,?,?,?)");
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
            throw new KindergardenException(e.getMessage());
        }
    }
    /**
     * updates child's notes and activity in database based on id match.
     * @param -child bean to be updated.
     * @return updated version of bean child
     */
    @Override
    public Child update(Child item) throws KindergardenException {
        try{
        PreparedStatement stmt = getConnection().prepareStatement("UPDATE child SET activity_id=?, child_notes_id=? WHERE id_child=?");
        stmt.setInt(1, item.getActivity().getId());
        stmt.setInt(2,item.getChildNotes().getId());
        stmt.setInt(3, item.getId());
        stmt.executeUpdate();
        return item;
    }catch (SQLException e){
        System.out.println("Problem pri radu sa bazom podataka");
        throw new KindergardenException(e.getMessage());
    }
    }

    /**
     * Delete of item child from database with given id
     * @param id - primary key of child
     */
    @Override
    public void delete(int id) throws KindergardenException{
        try{
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM child WHERE id_child = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage());
        }
    }

    /**
     * Lists all children from database.
     * @return List of children from database
     */

    @Override
    public List<Child> getAll() throws KindergardenException {
        List<Child> children = new ArrayList<>();
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM child");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Child child = new Child();
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
                children.add(child);
            }
            rs.close();
        }catch (SQLException e){
           throw new KindergardenException(e.getMessage());
        }
        return children;
    }

    /**
     * Lists all children from database from specific parent.
     * @params-id of specific parent
     * @return List of children of specific parent from database
     */

    @Override
    public ArrayList<Child> searchChildrenOfParent(int parentid) throws KindergardenException {
        ArrayList<Child> children=new ArrayList<>();
        try {
            PreparedStatement stmt= getConnection().prepareStatement("SELECT * FROM child WHERE parent_id = ?");
            stmt.setInt(1,parentid);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
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
                children.add(child);
            }

        } catch (SQLException e) {
           throw new KindergardenException(e.getMessage(),e);
        }
        return children;
    }

    /**
     * Lists all children from database from specific teacher.
     * @params-id of specific teacher
     * @return List of children of specific teacher from database
     */
    @Override
    public ArrayList<Child> searchChildrenOfTeacher(int teacherid) throws KindergardenException {
        ArrayList<Child> children=new ArrayList<>();
        try {
            PreparedStatement stmt= getConnection().prepareStatement("SELECT * FROM child WHERE teacher_id = ?");
            stmt.setInt(1,teacherid);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
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
                children.add(child);
            }
        } catch (SQLException e) {
           throw new KindergardenException(e.getMessage(),e);
        }
        return children;
    }
}

