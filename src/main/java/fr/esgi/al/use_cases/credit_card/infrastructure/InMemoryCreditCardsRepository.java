package fr.esgi.al.use_cases.credit_card.infrastructure;

import fr.esgi.al.kernel.NoSuchEntityException;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.credit_card.domain.CreditCardID;
import fr.esgi.al.use_cases.credit_card.domain.CreditCardRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryCreditCardsRepository implements CreditCardRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<CreditCardID, CreditCard> data = new ConcurrentHashMap<>();

    @Override
    public CreditCardID nextIdentity() {
        return new CreditCardID(counter.incrementAndGet());
    }

    @Override
    public CreditCard findById(CreditCardID creditCardId) throws NoSuchEntityException {
        return data.get(creditCardId);
    }

    @Override
    public void add(CreditCard creditCard) {
        data.put(creditCard.getId(), creditCard);
    }

    @Override
    public void delete(CreditCardID id) {
        data.remove(id);
    }

    @Override
    public List<CreditCard> findAll() {
        return List.copyOf(data.values());
    }
}
