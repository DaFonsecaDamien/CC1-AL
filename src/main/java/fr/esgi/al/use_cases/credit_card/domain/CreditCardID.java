package fr.esgi.al.use_cases.credit_card.domain;

import fr.esgi.al.kernel.ValueObjectID;

import java.util.Objects;

public final class CreditCardID implements ValueObjectID {
    private final int value;

    public CreditCardID(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCardID that = (CreditCardID) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CreditCardId{" +
                "value=" + value +
                '}';
    }
}
