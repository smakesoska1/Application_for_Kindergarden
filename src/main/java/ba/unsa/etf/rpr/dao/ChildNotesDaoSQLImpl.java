package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.ChildNotes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public ChildNotes add(ChildNotes item) {
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
