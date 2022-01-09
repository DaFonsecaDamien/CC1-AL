package fr.esgi.al.use_cases.tradesman.application;

import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.use_cases.membership.domain.MembershipID;
import fr.esgi.al.use_cases.membership.domain.MembershipRepository;
import fr.esgi.al.use_cases.tradesman.domain.Tradesman;

public class CreateTradesmanCommandHandler implements CommandHandler<CreateTradesman, MembershipID> {
    private final MembershipRepository membershipRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateTradesmanCommandHandler(MembershipRepository membershipRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.membershipRepository = membershipRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public MembershipID handle(CreateTradesman createTradesman) {
        final MembershipID membershipId = membershipRepository.nextIdentity();
        Tradesman tradesman = new Tradesman(membershipId, createTradesman.firstname, createTradesman.lastname, createTradesman.email, createTradesman.password);
        membershipRepository.add(tradesman);
        eventEventDispatcher.dispatch(new CreateTradesmanEvent(membershipId));
        return membershipId;
    }
}
