package fr.esgi.al.use_cases.contractor.domain;

import fr.esgi.al.kernel.Repository;
import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipID;

public interface ContractorRepository extends Repository<MembershipID, Membership> {
}
