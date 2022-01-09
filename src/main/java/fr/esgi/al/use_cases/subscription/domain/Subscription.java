package fr.esgi.al.use_cases.subscription.domain;

import fr.esgi.al.use_cases.payment.domain.Payment;

import java.util.ArrayList;
import java.util.List;

public class Subscription {
    private final List<Payment> payments;

    public Subscription() {
        this.payments = new ArrayList<>();
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
