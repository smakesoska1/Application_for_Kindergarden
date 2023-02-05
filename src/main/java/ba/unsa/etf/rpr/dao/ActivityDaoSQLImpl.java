package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Activity;

import java.sql.*;
import java.util.List;

public class ActivityDaoSQLImpl implements ActivityDao{

    private Connection conn;

    public ActivityDaoSQLImpl() {
        try {
            this.conn= DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPRbaza2", "freedb_sara123", "2AP?Su3RJ2zstx?");
        } catch (SQLException e) {
            System.out.println("Greska u radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Activity getById(int id) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM activity WHERE id_activity = ?");
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
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    private int getMaxId(){
        int id_activity=0;
        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT MAX(id_activity) FROM activity");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id_activity = rs.getInt(1);
                rs.close();
                return id_activity;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return id_activity;
    }


    @Override
    public Activity add(Activity item) {
        int id_activity=getMaxId()+1;
        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO activity (id_activity,activity_name) VALUES (?,?)");
            stmt.setInt(1,id_activity);
            stmt.setString(2, item.getActivityName());
            stmt.executeUpdate();
            item.setId(id_activity);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Activity update(Activity item) {
        try{
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE activity SET activity_name=? WHERE id_activity=?");
            stmt.setString(1, item.getActivityName());
            stmt.setInt(2, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(int id) {
        try{
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM activity WHERE id_activity = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Activity> getAll() {
        return null;
    }
}
