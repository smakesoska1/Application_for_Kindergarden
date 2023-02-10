package ba.unsa.etf.rpr.domain;

import java.time.LocalTime;
import java.util.Objects;

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
        if (!super.equals(o)) return false;

        Teacher teacher = (Teacher) o;

        if (!Objects.equals(username, teacher.username)) return false;
        if (!Objects.equals(password, teacher.password)) return false;
        if (!Objects.equals(startWork, teacher.startWork)) return false;
        return Objects.equals(endWork, teacher.endWork);
    }

    @Override
    public int hashCode() {
      return Objects.hash(username,password,startWork,endWork);
    }
}
