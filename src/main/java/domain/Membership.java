package domain;
import infrastructure.InMemoryMembershipRepository;
import infrastructure.MembershipRepository;
import kernel.Entity;

import java.util.Objects;

public final class Membership extends InMemoryMembershipRepository implements Entity<MembershipId> {

    private final MembershipId id;
    private final String firstname;
    private final String lastname;

    private Membership(String firstname, String lastname) {
        this.id = nextIdentity();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static Membership of(String firstname, String lastname){
        return new Membership(firstname,lastname);
    }

    public MembershipId getId(){
        return id;
    }

    @Override
    public MembershipId id() {
        return null;
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
