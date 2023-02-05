package ba.unsa.etf.rpr.domain;

import java.time.LocalTime;

public class Child extends Person{

    private Parent parent;
    private Teacher teacher;
    private Activity activity;
    private ChildNotes childNotes;
    private LocalTime startTime;
    private LocalTime endTime;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ChildNotes getChildNotes() {
        return childNotes;
    }

    public void setChildNotes(ChildNotes childNotes) {
        this.childNotes = childNotes;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Child{" +
                "parent=" + parent +
                ", teacher=" + teacher +
                ", activity=" + activity +
                ", childNotes=" + childNotes +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
