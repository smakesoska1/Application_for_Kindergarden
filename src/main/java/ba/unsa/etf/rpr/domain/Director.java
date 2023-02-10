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
        Director director = (Director) o;
        return director.getId()==getId();

    }

    @Override
    public int hashCode() {
       return Objects.hash(username,password,phoneNumber);
    }
}
