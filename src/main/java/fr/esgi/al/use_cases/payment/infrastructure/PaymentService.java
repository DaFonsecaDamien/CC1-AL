package fr.esgi.al.use_cases.payment.infrastructure;

import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.payment.domain.Payment;

public interface PaymentService {
    void process(Payment payment, CreditCard creditCard);
}
