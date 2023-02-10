package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ChildManager;
import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.*;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ChildTest {

    @Test

    public void searchChildrenOfTeacherTest() throws KindergardenException {

        ArrayList<Child> children=new ArrayList<>();
        ArrayList<Child> original=new ArrayList<>();
        original=DaoFactory.childDao().searchChildrenOfTeacher(2);
        Child kinder=new Child();

        Parent p= DaoFactory.parentDao().getById(2);
        Teacher t= DaoFactory.teacherDao().getById(2);
        Activity a=DaoFactory.activityDao().getById(4);
        ChildNotes cn= DaoFactory.childNotesDao().getById(3);

        kinder.setFirstName("Nidal");
        kinder.setSurname("Halilovic");
        kinder.setAdress("Geteova");
        kinder.setParent(p);
        kinder.setTeacher(t);
        kinder.setStartTime(LocalTime.of(10,0));
        kinder.setEndTime(LocalTime.of(18,0));
        kinder.setActivity(a);
        kinder.setChildNotes(cn);


        children.add(kinder);
        assertEquals(children.toString(),original.toString());

    }
}
