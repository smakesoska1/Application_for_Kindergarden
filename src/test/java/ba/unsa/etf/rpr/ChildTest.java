package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.*;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Child
 *
 */

public class ChildTest {

    /**
     * checking method searchChildrenOfTeacher
     */

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
        kinder.setSurname("Halic");
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

    /**
     * checking method searchChildrenOfParents
     */

    @Test

    public void searchChildrenOfParentsTest() throws KindergardenException {

        ArrayList<Child> children=new ArrayList<>();
        ArrayList<Child> original=new ArrayList<>();
        original=DaoFactory.childDao().searchChildrenOfParent(1);
        Child kinder=new Child();
        Child kinder2=new Child();

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
       a.setId(9);
       a.setActivityName("ples");

       ChildNotes cn=new ChildNotes();
       cn.setId(1);
       cn.setNoteName("Zaineteriran/na");

        kinder.setId(1);
        kinder.setFirstName("Lejna");
        kinder.setSurname("Mujic");
        kinder.setAdress("Novopazarska");
        kinder.setParent(p);
        kinder.setTeacher(t);
        kinder.setStartTime(LocalTime.of(8,0));
        kinder.setEndTime(LocalTime.of(17,0));
        kinder.setActivity(a);
        kinder.setChildNotes(cn);


        children.add(kinder);

        Parent p2=new Parent();
        p2.setId(1);
        p2.setFirstName("Fatima");
        p2.setSurname("Mujic");
        p2.setAdress("Novopazarska");
        p2.setUsername("fmujic");
        p2.setPassword("fmujic");
        p2.setPhoneNumber(62456726);

        Teacher t2=new Teacher();
        t2.setId(1);
        t2.setFirstName("Amina");
        t2.setSurname("Halilovic");
        t2.setAdress("adresa123");
        t2.setPassword("teacher1");
        t2.setPassword("teacher1");
        t2.setStartWork(LocalTime.of(7,0));
        t2.setEndWork(LocalTime.of(20,0));

        Activity a2=new Activity();
        a2.setId(8);
        a2.setActivityName("nogomet");

        ChildNotes cn2=new ChildNotes();
        cn2.setId(2);
        cn2.setNoteName("Nezaineteriran/na");

        kinder2.setId(3);
        kinder2.setFirstName("Sara");
        kinder2.setSurname("Mujic");
        kinder2.setAdress("Novopazarska");
        kinder2.setParent(p2);
        kinder2.setTeacher(t2);
        kinder2.setStartTime(LocalTime.of(8,0));
        kinder2.setEndTime(LocalTime.of(17,0));
        kinder2.setActivity(a2);
        kinder2.setChildNotes(cn2);


        children.add(kinder2);

        assertEquals(children,original);

    }

}
