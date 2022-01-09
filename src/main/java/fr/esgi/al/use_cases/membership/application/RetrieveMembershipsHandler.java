package fr.esgi.al.use_cases.membership.application;

import fr.esgi.al.kernel.QueryHandler;
import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipRepository;

import java.util.List;

public class RetrieveMembershipsHandler implements QueryHandler<RetrieveMemberships, List<Membership>> {
    private final MembershipRepository membershipRepository;

    public RetrieveMembershipsHandler(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public List<Membership> handle(RetrieveMemberships query) {
        return membershipRepository.findAll();
    }
}
