package fr.esgi.al.use_cases.credit_card.application;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.use_cases.credit_card.domain.CreditCardID;
import fr.esgi.al.use_cases.membership.domain.MembershipID;

public class CreateCreditCardEvent implements ApplicationEvent {
    private final CreditCardID creditCardID;

    public CreateCreditCardEvent(CreditCardID creditCardID) {
        this.creditCardID = creditCardID;
    }
}
