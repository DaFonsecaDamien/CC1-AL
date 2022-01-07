package infrastructure;

import domain.Membership;

public class MembershipController {
    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    public void addFromRequest(Membership membership) {
        membershipService.addMembership(membership);
    }
}
