package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Parent;

/**
 * Factory method for implementation of DAOs
 *
 */

public class DaoFactory {
    private static final DirectorDao directorDao = new DirectorDaoSQLImpl();
    private static final TeacherDao teacherDao = new TeacherDaoSQLImpl();
    private static final ParentDao parentDao = new ParentDaoSQLImpl();
    private static final ChildDao childDao = new ChildDaoSQLImpl();
    private static final ActivityDao activityDao = new ActivityDaoSQLImpl();
    private static final ChildNotesDao childNotesDao = new ChildNotesDaoSQLImpl();

    private DaoFactory(){
    }

    public static DirectorDao directorDao(){
        return directorDao;
    }

    public static TeacherDao teacherDao(){
        return teacherDao;
    }

    public static ParentDao parentDao(){
        return parentDao;
    }

    public static ChildDao childDao(){
        return childDao;
    }

    public static ActivityDao activityDao(){
        return activityDao;
    }

    public static ChildNotesDao childNotesDao(){
        return childNotesDao;
    }
}
