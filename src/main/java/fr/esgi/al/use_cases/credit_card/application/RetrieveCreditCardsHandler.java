package fr.esgi.al.use_cases.credit_card.application;

import fr.esgi.al.kernel.QueryHandler;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.credit_card.domain.CreditCardRepository;

import java.util.List;

public class RetrieveCreditCardsHandler implements QueryHandler<RetrieveCreditCards, List<CreditCard>> {
    private final CreditCardRepository creditCardRepository;

    public RetrieveCreditCardsHandler(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public List<CreditCard> handle(RetrieveCreditCards query) {
        return creditCardRepository.findAll();
    }
}
