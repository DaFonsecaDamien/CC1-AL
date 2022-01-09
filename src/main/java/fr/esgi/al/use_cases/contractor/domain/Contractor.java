package fr.esgi.al.use_cases.contractor.domain;

import fr.esgi.al.domain.Project;
import fr.esgi.al.use_cases.membership.application.MembershipDTO;
import fr.esgi.al.use_cases.membership.domain.Email;
import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipID;
import fr.esgi.al.use_cases.membership.domain.Password;

import java.util.ArrayList;
import java.util.List;

public final class Contractor extends Membership {
    private final List<Project> projects;

    public Contractor(MembershipID id, String firstname, String lastname, Email email, Password password) {
        super(id, firstname, lastname, email, password);
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }
}
