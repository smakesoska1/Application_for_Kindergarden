package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Director extends Person{
    private String username;
    private String password;
    private int phoneNumber;

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Director director = (Director) o;

        if (phoneNumber != director.phoneNumber) return false;
        if (!Objects.equals(username, director.username)) return false;
        return Objects.equals(password, director.password);
    }

    @Override
    public int hashCode() {
       return Objects.hash(username,password,phoneNumber);
    }
}
