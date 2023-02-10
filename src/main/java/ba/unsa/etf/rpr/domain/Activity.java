package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Activity implements Idable{
    private int id;
    private String activityName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (id != activity.id) return false;
        return Objects.equals(activityName, activity.activityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,activityName);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityName='" + activityName + '\'' +
                '}';
    }
}
