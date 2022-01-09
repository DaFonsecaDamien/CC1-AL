package fr.esgi.al.use_cases.payment.infrastructure;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.payment.domain.Payment;

public class PaymentEvent implements ApplicationEvent {
    public final Payment payment;
    public final CreditCard creditCard;

    public PaymentEvent(Payment payment, CreditCard creditCard) {
        this.payment = payment;
        this.creditCard = creditCard;
    }
}
