package fr.esgi.al.use_cases.membership.domain;

import fr.esgi.al.kernel.Repository;
import fr.esgi.al.use_cases.membership.application.MembershipDTO;

import java.util.List;

public interface MembershipRepository extends Repository<MembershipID, Membership> {
    List<Membership> findAll();
}
