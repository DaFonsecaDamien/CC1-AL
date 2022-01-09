package fr.esgi.al.use_cases.contractor.application;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.use_cases.membership.domain.MembershipID;

public class CreateContractorEvent implements ApplicationEvent {
    private final MembershipID membershipId;

    public CreateContractorEvent(MembershipID membershipId) {
        this.membershipId = membershipId;
    }
}
