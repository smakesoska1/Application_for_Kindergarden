package ba.unsa.etf.rpr.domain;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Java Bean class for child's teacher
 */

public class Teacher extends Person{
    private String username;
    private String password;
    private LocalTime startWork;
    private LocalTime endWork;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalTime getStartWork() {
        return startWork;
    }

    public void setStartWork(LocalTime startWork) {
        this.startWork = startWork;
    }

    public LocalTime getEndWork() {
        return endWork;
    }

    public void setEndWork(LocalTime endWork) {
        this.endWork = endWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;


        Teacher teacher = (Teacher) o;

        return teacher.getId()==getId();
    }

    @Override
    public int hashCode() {
      return Objects.hash(username,password,startWork,endWork);
    }
}
