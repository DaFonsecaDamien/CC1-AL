package fr.esgi.al.use_cases.payment.domain;

import fr.esgi.al.kernel.ValueObjectID;
import fr.esgi.al.use_cases.membership.domain.MembershipID;

import java.util.Objects;
import java.util.UUID;

public class PaymentID implements ValueObjectID {
    private final int value;

    public PaymentID(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentID that = (PaymentID) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PaymentId{" +
                "value=" + value +
                '}';
    }
}