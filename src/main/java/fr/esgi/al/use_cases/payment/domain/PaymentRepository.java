package fr.esgi.al.use_cases.payment.domain;

import fr.esgi.al.kernel.Repository;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;

import java.util.List;

public interface PaymentRepository extends Repository<PaymentID, Payment> {
    List<Payment> findAll();
}
