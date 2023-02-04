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
                activity.setActivityName(rs.getString("activity_name")); //ovo samo kad se doda implementacija i toga ce raditi....
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

    @Override
    public Activity add(Activity item) {
        return null;
    }

    @Override
    public Activity update(Activity item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Activity> getAll() {
        return null;
    }
}
