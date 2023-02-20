package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.List;

/**
 * Business Logic Layer for management of Techer
 */

public class TeacherManager {

    public void validateUsername(String username) throws KindergardenException {
        if (username == null || username.length() > 45 || username.length() < 4){
            throw new KindergardenException("Username must be between 4 and 45 chars");
        }
    }

    public static boolean validateTeacher(String correctName, String correctPass) {
        try {
            Teacher teacher= DaoFactory.teacherDao().searchTeacherByUsername(correctName);
            if(teacher.getPassword().equals(correctPass))
                return true;
        } catch (KindergardenException e) {
            System.out.println("Nepostojeci username i password");
            return false;
        }
        return true;
    }

    public List<Teacher> getAll() throws KindergardenException {
        return DaoFactory.teacherDao().getAll();
    }

    public void delete(int id) throws KindergardenException{
        try{
            DaoFactory.teacherDao().delete(id);
        }catch (KindergardenException e){
            if (e.getMessage().contains("FOREIGN KEY")){
                throw new KindergardenException("Cannot delete teacher which is related to child. First delete/update related child before deleting teacher.");
            }
            throw e;
        }
    }

    public Teacher getById(int teacherId) throws KindergardenException{
        return DaoFactory.teacherDao().getById(teacherId);
    }

    public void update(Teacher t) throws KindergardenException{
        validateUsername(t.getUsername());
        DaoFactory.teacherDao().update(t);
    }

    public Teacher add(Teacher t) throws KindergardenException {
        validateUsername(t.getUsername());
        return DaoFactory.teacherDao().add(t);
    }

    public Teacher searchTeacherByUsername(String username) throws KindergardenException{
        validateUsername(username);
        return DaoFactory.teacherDao().searchTeacherByUsername(username);
    }
}
