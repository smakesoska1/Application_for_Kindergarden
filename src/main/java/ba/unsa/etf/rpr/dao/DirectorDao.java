package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Director;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

public interface DirectorDao extends Dao<Director> {
    Director searchDirectorByUsername(String username) throws KindergardenException;
}
