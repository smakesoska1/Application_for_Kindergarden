package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ChildNotesManager;
import ba.unsa.etf.rpr.domain.ChildNotes;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * Test class for class child notes manager
 *
 */

public class ChildNotesTest {

    /**
     *checking method getById from child notes manager
     */

    @Test
    public void getByIdNoteTest() throws KindergardenException {
        ChildNotesManager manager=new ChildNotesManager();
        ChildNotes cn=new ChildNotes();

        cn.setId(3);
        cn.setNoteName("Losa koncentracija");

        Assertions.assertEquals(cn,manager.getById(3));
    }
}
