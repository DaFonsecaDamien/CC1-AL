package fr.esgi.al.use_cases.membership.exposition;

@SuppressWarnings("all")
public class MembershipResponse {
    public String id;
    public String lastname;
    public String firstname;

    public MembershipResponse(String id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "MembershipDTO{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
