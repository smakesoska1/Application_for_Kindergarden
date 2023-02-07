package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Activity;
import ba.unsa.etf.rpr.exceptions.KindergardenException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDaoSQLImpl extends  AbstractDao implements ActivityDao{

    private Connection conn;

    public ActivityDaoSQLImpl() {
        super("activity");
    }

    @Override
    public Activity getById(int id) throws KindergardenException {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM activity WHERE id_activity = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                Activity activity = new Activity();
                activity.setId(rs.getInt("id_activity"));
                activity.setActivityName(rs.getString("activity_name"));
                rs.close();
                return activity;
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new KindergardenException(e.getMessage(),e);
        }
    }

    private int getMaxId() throws KindergardenException{
        int id_activity=0;
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT MAX(id_activity) FROM activity");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_activity = rs.getInt(1);
                rs.close();
                return id_activity;
            }
        } catch (SQLException e) {
            throw new KindergardenException(e.getMessage());
        }
        return id_activity;
    }


    @Override
    public Activity add(Activity item) throws KindergardenException {
        int id_activity=getMaxId()+1;
        try {
            PreparedStatement stmt = getConnection().prepareStatement("INSERT INTO activity (id_activity,activity_name) VALUES (?,?)");
            stmt.setInt(1,id_activity);
            stmt.setString(2, item.getActivityName());
            stmt.executeUpdate();
            item.setId(id_activity);
            return item;
        } catch (SQLException e) {
            throw new KindergardenException(e.getMessage());
        }
    }

    @Override
    public Activity update(Activity item) throws KindergardenException {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("UPDATE activity SET activity_name=? WHERE id_activity=?");
            stmt.setString(1, item.getActivityName());
            stmt.setInt(2, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            throw new KindergardenException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) throws KindergardenException {
        try{
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM activity WHERE id_activity = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
           throw new KindergardenException(e.getMessage());
        }
    }

    @Override
    public List<Activity> getAll() throws KindergardenException {
        List<Activity> activities = new ArrayList<>();
        try{
            PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM activity");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Activity activity = new Activity();
                activity.setId(rs.getInt("id_activity"));
                activity.setActivityName(rs.getString("activity_name"));
                activities.add(activity);
            }
            rs.close();
        }catch (SQLException e){
            throw new KindergardenException(e.getMessage());
        }
        return activities;

    }
}
