package fr.esgi.al.use_cases.tradesman.application;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.use_cases.membership.domain.MembershipID;

public class CreateTradesmanEvent implements ApplicationEvent {
    private final MembershipID membershipId;

    public CreateTradesmanEvent(MembershipID membershipId) {
        this.membershipId = membershipId;
    }
}
