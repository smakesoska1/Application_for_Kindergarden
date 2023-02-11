package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.ActivityManager;
import ba.unsa.etf.rpr.dao.ActivityDao;
import ba.unsa.etf.rpr.dao.ActivityDaoSQLImpl;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.ParentDao;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ActivityMock {
    private ActivityManager activityManager;
    private Activity activity;
    private ActivityDaoSQLImpl activityDao;
    private List<Activity> activities;

    @BeforeEach
    public void initialization() throws KindergardenException {
        activityManager=Mockito.mock(ActivityManager.class);
        activities=new ArrayList<>();
        Activity activity1=new Activity();
        activity1.setId(1);
        activity1.setActivityName("Sleeping");
        activities.add(activity1);
        Activity activity2=new Activity();
        activity2.setId(2);
        activity2.setActivityName("Watching TV");
        activities.add(activity2);
        Mockito.when(activityManager.getAll()).thenReturn(activities);
    }

    @Test
    public void testGetAll() throws KindergardenException {
        List<Activity> retrieved = activityManager.getAll();
        assertEquals(activities, retrieved);
    }
}
