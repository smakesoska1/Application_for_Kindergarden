package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Director;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

/**
 * Dao interface for Director domain bean
 */

public interface DirectorDao extends Dao<Director> {
    /**
     * Returns director that if found based on username.
     *
     * @param -username
     * @return director
     */
    Director searchDirectorByUsername(String username) throws KindergardenException;
}
