package ba.unsa.etf.rpr.domain;

import java.time.LocalTime;
import java.util.Objects;

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
        if (!super.equals(o)) return false;

        Child child = (Child) o;

        if (!Objects.equals(parent, child.parent)) return false;
        if (!Objects.equals(teacher, child.teacher)) return false;
        if (!Objects.equals(activity, child.activity)) return false;
        if (!Objects.equals(childNotes, child.childNotes)) return false;
        if (!Objects.equals(startTime, child.startTime)) return false;
        return Objects.equals(endTime, child.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent,teacher,activity,childNotes,startTime,endTime);
    }
}
