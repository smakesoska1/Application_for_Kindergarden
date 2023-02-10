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


    @Test

    public void searchChildrenOfParentsTest() throws KindergardenException {

        ArrayList<Child> children=new ArrayList<>();
        ArrayList<Child> original=new ArrayList<>();
        original=DaoFactory.childDao().searchChildrenOfParent(1);
        Child kinder=new Child();

       Parent p=new Parent();
       p.setId(1);
       p.setFirstName("Fatima");
       p.setSurname("Mujic");
       p.setAdress("Novopazarska");
       p.setUsername("fmujic");
       p.setPassword("fmujic");
       p.setPhoneNumber(62456726);

       Teacher t=new Teacher();
       t.setId(1);
       t.setFirstName("Amina");
       t.setSurname("Halilovic");
       t.setAdress("adresa123");
       t.setPassword("teacher1");
       t.setPassword("teacher1");
       t.setStartWork(LocalTime.of(7,0));
       t.setEndWork(LocalTime.of(20,0));

       Activity a=new Activity();
       a.setId(3);
       a.setActivityName("igra u dvoristu");

       ChildNotes cn=new ChildNotes();
       cn.setId(2);
       cn.setNoteName("Nezaineteriran/na");

        kinder.setId(1);
        kinder.setFirstName("Lejna");
        kinder.setSurname("Lejnic");
        kinder.setAdress("Novopazarska");
        kinder.setParent(p);
        kinder.setTeacher(t);
        kinder.setStartTime(LocalTime.of(8,0));
        kinder.setEndTime(LocalTime.of(17,0));
        kinder.setActivity(a);
        kinder.setChildNotes(cn);


        children.add(kinder);

        assertEquals(children,original);

    }

}
