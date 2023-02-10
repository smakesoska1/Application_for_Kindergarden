package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.DirectorManager;
import ba.unsa.etf.rpr.business.TeacherManager;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    @Test
    public void searchByUsernameTeacherTest() throws KindergardenException {
        TeacherManager manager=new TeacherManager();
        Teacher username=manager.searchTeacherByUsername("teacher1");
        Assertions.assertEquals("Amina",username.getFirstName());
    }

    @Test
    public void searchByUsernameTeacherExceptionTest(){
        TeacherManager manager=new TeacherManager();
        Assertions.assertThrows(KindergardenException.class,()->manager.searchTeacherByUsername("ah"));
    }
}
