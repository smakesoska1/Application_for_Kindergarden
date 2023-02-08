package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.util.List;

public class ActivityManager {
    public List<Activity> getAll() throws KindergardenException{
        return DaoFactory.activityDao().getAll();
    }

    public void delete(int id) throws KindergardenException{
        DaoFactory.activityDao().delete(id);
    }

    public Activity getById(int activityId) throws KindergardenException{
        return DaoFactory.activityDao().getById(activityId);
    }

    public void update(Activity a) throws KindergardenException{
        DaoFactory.activityDao().update(a);
    }

    public Activity add(Activity a) throws KindergardenException{
        return DaoFactory.activityDao().add(a);
    }

}
