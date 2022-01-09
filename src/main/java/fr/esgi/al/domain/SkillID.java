package fr.esgi.al.domain;

import fr.esgi.al.kernel.ValueObjectID;

import java.util.Objects;

public class SkillID implements ValueObjectID {
    private final int value;

    public SkillID(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillID that = (SkillID) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "SkillID{" +
                "value=" + value +
                '}';
    }
}
