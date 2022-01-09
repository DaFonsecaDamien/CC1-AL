package fr.esgi.al.use_cases.credit_card.application;

import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.credit_card.domain.CreditCardID;
import fr.esgi.al.use_cases.credit_card.domain.CreditCardRepository;

public class CreateCreditCardCommandHandler implements CommandHandler<CreateCreditCard, CreditCardID> {
    private final CreditCardRepository creditCardRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateCreditCardCommandHandler(CreditCardRepository creditCardRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.creditCardRepository = creditCardRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public CreditCardID handle(CreateCreditCard createCreditCard) {
        final CreditCardID creditCardID = creditCardRepository.nextIdentity();
        CreditCard creditCard = new CreditCard(creditCardID, createCreditCard.number, createCreditCard.securityCode, createCreditCard.ownerName);
        creditCardRepository.add(creditCard);
        eventEventDispatcher.dispatch(new CreateCreditCardEvent(creditCardID));
        return creditCardID;
    }
}
