package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ParentManager;
import ba.unsa.etf.rpr.business.TeacherManager;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for Parent Manager
 */

public class ParentTest {
    /**
     * checking if delete method in parent manager throws exception
     */

    @Test
    public void parentDeleteTest (){
        ParentManager manager=new ParentManager();
        Assertions.assertThrows(KindergardenException.class,()->manager.delete(1));
    }
}
