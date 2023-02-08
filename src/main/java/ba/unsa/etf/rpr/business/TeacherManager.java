package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Parent;
import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.List;

public class TeacherManager {

    public void validateUsername(String username) throws KindergardenException {
        if (username == null || username.length() > 45 || username.length() < 2){
            throw new KindergardenException("Username must be between 2 and 45 chars");
        }
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

    public Teacher add(Teacher t) throws KindergardenException{
        validateUsername(t.getUsername());
        return DaoFactory.teacherDao().add(t);
    }
}
