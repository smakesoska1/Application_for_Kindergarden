package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.domain.Child;
import ba.unsa.etf.rpr.domain.ChildNotes;

import java.sql.*;
import java.util.List;

public class ChildNotesDaoSQLImpl implements ChildNotesDao{

    private Connection conn;

    public ChildNotesDaoSQLImpl() {
        try {
            this.conn= DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza2", "freedb_sara123", "2AP?Su3RJ2zstx?");
        } catch (SQLException e) {
            System.out.println("Greska u radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ChildNotes getById(int id) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM child_notes WHERE id_note = ?");
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
            System.out.println(e.getMessage());
        }
        return null;
    }

    private int getMaxId(){
        int id_note=0;
        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT MAX(id_note) FROM child_notes");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_note = rs.getInt(1);
                rs.close();
                return id_note;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return id_note;
    }


    @Override
    public ChildNotes add(ChildNotes item) {
        int id_note=getMaxId()+1;
        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO child_notes (id_note,note_name) VALUES (?,?)");
            stmt.setInt(1,id_note);
            stmt.setString(2, item.getNoteName());
            stmt.executeUpdate();
            item.setId(id_note);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ChildNotes update(ChildNotes item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<ChildNotes> getAll() {
        return null;
    }
}
