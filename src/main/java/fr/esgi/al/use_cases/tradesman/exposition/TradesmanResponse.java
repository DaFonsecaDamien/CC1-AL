package fr.esgi.al.use_cases.tradesman.exposition;

import fr.esgi.al.domain.Skill;
import fr.esgi.al.use_cases.membership.exposition.MembershipResponse;

import java.util.List;

public class TradesmanResponse extends MembershipResponse {

    private final List<Skill> skills;

    public TradesmanResponse(String id, String lastname, String firstname, List<Skill> skills) {
        super(id, lastname, firstname);
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "TradesmanDTO{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
