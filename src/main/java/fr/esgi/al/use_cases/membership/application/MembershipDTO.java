package fr.esgi.al.use_cases.membership.application;

import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipID;
public class MembershipDTO {
    public final MembershipID id;
    public final String lastname;
    public final String firstname;

    public MembershipDTO(MembershipID id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public MembershipID getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public static MembershipDTO of(Membership membership) {
        return new MembershipDTO(membership.id(), membership.getFirstname(), membership.getLastname());
    }
}
