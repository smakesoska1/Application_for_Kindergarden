package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Teacher;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

/**
 * Dao interface for Teacher domain bean
 */

public interface TeacherDao extends Dao<Teacher> {
    /**
     * Returns teacher that if found based on username.
     *
     * @param -username
     * @return teacher
     */
    Teacher searchTeacherByUsername(String username) throws KindergardenException;
}
