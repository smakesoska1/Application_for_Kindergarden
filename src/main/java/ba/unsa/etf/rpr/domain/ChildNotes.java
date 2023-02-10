package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class ChildNotes implements Idable{
    private int id;
    private String noteName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChildNotes that = (ChildNotes) o;

        return that.id==id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,noteName);
    }

    @Override
    public String toString() {
        return "ChildNotes{" +
                "noteName='" + noteName + '\'' +
                '}';
    }
}
