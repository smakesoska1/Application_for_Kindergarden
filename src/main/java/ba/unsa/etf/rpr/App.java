package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ActivityDaoSQLImpl a=new ActivityDaoSQLImpl();
        Activity ac=a.getById(1);
        System.out.println(ac);

        /*Activity b=new Activity();
        b.setActivityName("pjevanje");
        a.add(b);*/

       /* Activity c=new Activity();
        c.setActivityName("brojanje");
        c.setId(1);
        a.update(c);*/

       //a.delete(6);
        System.out.println(a.getAll().size());

       /* ChildNotesDaoSQLImpl cn=new ChildNotesDaoSQLImpl();
        cn.getAll();
        System.out.println(a.getAll().size());
        ChildNotes note=new ChildNotes();
        note.setNoteName("Nema volje za ucenjem");
        cn.add(note);*/

        /*DirectorDaoSQLImpl d=new DirectorDaoSQLImpl();
        Director director=new Director();

        director.setFirstName("Nidal");
        director.setSurname("Lalic");
        director.setAdress("Maglajska");
        director.setUsername("nlalic1");
        director.setPassword("nlalic1");
        director.setPhoneNumber(5230267);
        director.setId(1);

        d.update(director);*/

        ParentDaoSQLImpl par=new ParentDaoSQLImpl();
        Parent p=par.getById(2);
        System.out.println(p);



    }
}
