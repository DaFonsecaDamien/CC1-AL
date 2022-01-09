package fr.esgi.al.use_cases.membership.domain;

import fr.esgi.al.kernel.Entity;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.payment.domain.Payment;
import fr.esgi.al.use_cases.subscription.domain.Subscription;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Membership implements Entity<MembershipID> {

    private final MembershipID id;
    private final String firstname;
    private final String lastname;
    private final Email email;
    private final Password password;

    public Membership(MembershipID id, String firstname, String lastname, Email email, Password password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public MembershipID getId() {
        return id;
    }

    @Override
    public MembershipID id() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
