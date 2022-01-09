package fr.esgi.al.use_cases.tradesman.domain;

import fr.esgi.al.kernel.Repository;
import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipID;

public interface TradesmanRepository extends Repository<MembershipID, Membership> {
}
