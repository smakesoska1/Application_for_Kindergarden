package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.DirectorManager;
import ba.unsa.etf.rpr.business.TeacherManager;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectorTest {

    @Test
    public void searchByUsernameDirectorTest() throws KindergardenException {

        DirectorManager manager=new DirectorManager();
        Assertions.assertEquals(manager.searchDirectorByUsername("nhalilovic1"),null);
    }





}
