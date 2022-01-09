package fr.esgi.al.use_cases.contractor.application;

import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.use_cases.contractor.domain.Contractor;
import fr.esgi.al.use_cases.membership.domain.MembershipID;
import fr.esgi.al.use_cases.membership.domain.MembershipRepository;


public class CreateContractorCommandHandler implements CommandHandler<CreateContractor, MembershipID> {

    private final MembershipRepository membershipRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateContractorCommandHandler(MembershipRepository membershipRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.membershipRepository = membershipRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public MembershipID handle(CreateContractor createContractor) {
        final MembershipID membershipId = membershipRepository.nextIdentity();
        Contractor contractor = new Contractor(membershipId, createContractor.firstname, createContractor.lastname, createContractor.email, createContractor.password);
        membershipRepository.add(contractor);
        eventEventDispatcher.dispatch(new CreateContractorEvent(membershipId));
        return membershipId;
    }
}
