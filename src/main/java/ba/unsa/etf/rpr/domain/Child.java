package ba.unsa.etf.rpr.domain;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Java Bean for children in kindergarden
 */

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;
        return child.getId()==getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent,teacher,activity,childNotes,startTime,endTime);
    }
}
