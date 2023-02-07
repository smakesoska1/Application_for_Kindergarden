package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.*;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        /*System.out.println( "Hello World!" );
        ActivityDaoSQLImpl a=new ActivityDaoSQLImpl();
        Activity ac=a.getById(1);
        System.out.println(ac);*/

        /*Activity b=new Activity();
        b.setActivityName("pjevanje");
        a.add(b);*/

       /* Activity c=new Activity();
        c.setActivityName("brojanje");
        c.setId(1);
        a.update(c);*/

       //a.delete(6);
        //System.out.println(a.getAll().size());

       /* ChildNotesDaoSQLImpl cn=new ChildNotesDaoSQLImpl();
        cn.getAll();
        System.out.println(a.getAll().size());
        ChildNotes note=new ChildNotes();
        note.setNoteName("Nema volje za ucenjem");
        cn.add(note);*/

        Director director=new Director();
        director.setFirstName("Nidal");
        director.setSurname("Lalic");
        director.setAdress("Maglajska");
        director.setUsername("nlalic1");
        director.setPassword("password");
        director.setPhoneNumber(5230267);
        director.setId(1);

        DaoFactory.directorDao().update(director);

        /*ParentDaoSQLImpl par=new ParentDaoSQLImpl();
        Parent p=par.getById(2);
        System.out.println(p);

        System.out.println(par.getAll().size());*/

       /* TeacherDao dao=new TeacherDaoSQLImpl();
        Teacher t= null;
        try {
            t = dao.getById(1);
        } catch (PersonException e) {
            e.printStackTrace();
        }
        System.out.println(t);*/

       /* Teacher teacher=new Teacher();
        teacher.setStartWork(LocalTime.of(7,0));
        teacher.setEndWork(LocalTime.of(20,0));
        teacher.setId(1);
        dao.update(teacher);*/

        /*ChildDao dao=new ChildDaoSQLImpl();
        Child c=dao.getById(1);
        System.out.println(c);*/

        TeacherDao dao=new TeacherDaoSQLImpl();
        Teacher t=dao.searchTeacherByUsername("teacher1");
        System.out.println(t);

        DirectorDao dao1=new DirectorDaoSQLImpl();
        Director d=dao1.searchDirectorByUsername("nlalic1");
        System.out.println(d);

        ParentDao dao2=new ParentDaoSQLImpl();
        Parent p=dao2.searchParentByUsername("ahalic");
        System.out.println(p);

        ArrayList<Child> children;
        ChildDao dao3=new ChildDaoSQLImpl();
        children=dao3.searchChildrenOfParent(2);

        for(int i=0;i<children.size();i++){
            System.out.println(children.get(i));
        }

        List<Teacher> teachers = DaoFactory.teacherDao().getAll();
        System.out.println(teachers);

    }
}
