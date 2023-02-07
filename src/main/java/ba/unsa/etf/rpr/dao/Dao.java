package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.List;

public interface Dao<T>{
    T getById(int id) throws KindergardenException;

    T add(T item) throws KindergardenException;

    T update(T item) throws KindergardenException;

    void delete(int id) throws KindergardenException;

    List<T> getAll() throws KindergardenException;
}
