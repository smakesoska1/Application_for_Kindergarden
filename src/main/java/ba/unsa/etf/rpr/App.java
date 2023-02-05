package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.ActivityDaoSQLImpl;
import ba.unsa.etf.rpr.dao.TeacherDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.domain.Teacher;

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




    }
}
