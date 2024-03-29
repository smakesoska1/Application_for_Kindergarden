package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.ChildNotes;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MySQL implementation of the DAO
 */

public class ChildNotesDaoSQLImpl extends AbstractDao implements ChildNotesDao{

    private Connection conn;

    /**
     * constructor of ChildNodesDaoSQLImplementation
     */
    public ChildNotesDaoSQLImpl() {
        super("child_notes");
    }


    /**
     * get notes from database base on ID
     * @param -id primary key of child's note
     * @return note from database
     */
    @Override
    public ChildNotes getById(int id) throws KindergardenException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM child_notes WHERE id_note = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                ChildNotes note = new ChildNotes();
                note.setId(rs.getInt("id_note"));
                note.setNoteName(rs.getString("note_name"));
                rs.close();
                return note;
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage());
        }
    }

    private int getMaxId() throws KindergardenException{
        int id_note=0;
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT MAX(id_note) FROM child_notes");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_note = rs.getInt(1);
                rs.close();
                return id_note;
            }
        } catch (SQLException e) {
            throw new KindergardenException(e.getMessage());
        }
        return id_note;
    }


    /**
     * Saves note into database
     * @param -Child Note bean for saving to database
     * @return saved note with id field
     */
    @Override
    public ChildNotes add(ChildNotes item) throws KindergardenException {
        int id_note=getMaxId()+1;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO child_notes (id_note,note_name) VALUES (?,?)");
            stmt.setInt(1,id_note);
            stmt.setString(2, item.getNoteName());
            stmt.executeUpdate();
            item.setId(id_note);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage());
        }
    }

    /**
     * Fully updates notes in database based on id match.
     * @param -note item bean to be updated.
     * @return updated version of bean child note
     */
    @Override
    public ChildNotes update(ChildNotes item) throws KindergardenException {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE child_notes SET note_name=? WHERE id_note=?");
            stmt.setString(1, item.getNoteName());
            stmt.setInt(2, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage());
        }
    }


    /**
     * Delete of item note from database with given id
     * @param id - primary key of child note
     */
    @Override
    public void delete(int id) throws KindergardenException {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM child_notes WHERE id_note = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            throw new KindergardenException(e.getMessage());
        }
    }

    /**
     * Lists all notes from database.
     * @return List of notes from database
     */
    @Override
    public List<ChildNotes> getAll() throws KindergardenException {
        List<ChildNotes> notes = new ArrayList<>();
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM child_notes");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ChildNotes note = new ChildNotes();
                note.setId(rs.getInt("id_note"));
                note.setNoteName(rs.getString("note_name"));
                notes.add(note);
            }
            rs.close();
        }catch (SQLException e){
         throw new KindergardenException(e.getMessage(),e);
        }
        return notes;
    }
}
