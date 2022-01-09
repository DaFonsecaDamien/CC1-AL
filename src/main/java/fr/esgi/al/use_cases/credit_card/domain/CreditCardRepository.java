package fr.esgi.al.use_cases.credit_card.domain;

import fr.esgi.al.kernel.Repository;

import java.util.List;

public interface CreditCardRepository extends Repository<CreditCardID, CreditCard> {
    List<CreditCard> findAll();
}
