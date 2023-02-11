package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.ActivityDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.exceptions.KindergardenException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ActivityTest {

    @Test
    public void testUpdateActivity() throws KindergardenException {
        ActivityDaoSQLImpl activityDao=new ActivityDaoSQLImpl();
        Activity originalActivity = activityDao.getById(1);

        Activity updatedActivity = new Activity();
        updatedActivity.setId(1);
        updatedActivity.setActivityName("Igranje");
        String updateAc=updatedActivity.getActivityName();

        activityDao.update(updatedActivity);
        Activity retrievedActivity = activityDao.getById(1);
        String newName=retrievedActivity.getActivityName();

        assertNotNull(originalActivity);
        assertNotNull(retrievedActivity);
        assertEquals(newName, updateAc);
    }
    @Test
    public void testGetAll() throws KindergardenException{
        ActivityDaoSQLImpl activityDao = Mockito.mock(ActivityDaoSQLImpl.class);
        List<Activity> expectedActivities = new ArrayList<>();
        Activity activity1 = new Activity();
        activity1.setId(1);
        activity1.setActivityName("Activity 1");
        expectedActivities.add(activity1);
        Activity activity2 = new Activity();
        activity2.setId(2);
        activity2.setActivityName("Activity 2");
        expectedActivities.add(activity2);
        when(activityDao.getAll()).thenReturn(expectedActivities);

        List<Activity> retrievedActivities = activityDao.getAll();
        assertEquals(expectedActivities, retrievedActivities);
    }

}
