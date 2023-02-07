package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

public interface TeacherDao extends Dao<Teacher> {
    Teacher searchTeacherByUsername(String username) throws KindergardenException;
}
