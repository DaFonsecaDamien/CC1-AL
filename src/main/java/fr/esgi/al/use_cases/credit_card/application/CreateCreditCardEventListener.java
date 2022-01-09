package fr.esgi.al.use_cases.credit_card.application;

import fr.esgi.al.kernel.EventListener;
import fr.esgi.al.use_cases.contractor.application.CreateContractorEvent;

public class CreateCreditCardEventListener implements EventListener<CreateCreditCardEvent> {
    @Override
    public void listenTo(CreateCreditCardEvent createCreditCardEvent) {
        System.out.println("listening CreateCreditCardEvent.");
    }
}
