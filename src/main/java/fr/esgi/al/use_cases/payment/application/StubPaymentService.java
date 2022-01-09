package fr.esgi.al.use_cases.payment.application;

import fr.esgi.al.kernel.ApplicationLogger;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.payment.domain.Payment;
import fr.esgi.al.use_cases.payment.infrastructure.PaymentService;
import org.springframework.stereotype.Service;

@Service
public final class StubPaymentService implements PaymentService {

    private final ApplicationLogger applicationLogger;

    public StubPaymentService(ApplicationLogger applicationLogger) {
        this.applicationLogger = applicationLogger;
    }

    @Override
    public void process(Payment payment, CreditCard creditCard) {
        applicationLogger.log("Owner : " + creditCard.getOwnerName() +"process to a payment with card : "+ creditCard.getNumber() +"of"+ payment.getAmount() +" $");
    }
}
