package fr.esgi.al.use_cases.contractor.exposition;

import fr.esgi.al.domain.Project;
import fr.esgi.al.use_cases.membership.exposition.MembershipResponse;

import java.util.List;

public class ContractorResponse extends MembershipResponse {

    public final List<Project> projects;

    public ContractorResponse(String id, String lastname, String firstname, List<Project> projects) {
        super(id, lastname, firstname);
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "ContractorDTO{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", projects='" + projects + '\'' +
                '}';
    }
}
