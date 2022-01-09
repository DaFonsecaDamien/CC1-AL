package fr.esgi.al.domain;

import fr.esgi.al.kernel.ValueObjectID;

import java.util.Objects;

public class ProjectID implements ValueObjectID {
    private final int value;

    public ProjectID(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectID that = (ProjectID) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ProjectID{" +
                "value=" + value +
                '}';
    }
}
