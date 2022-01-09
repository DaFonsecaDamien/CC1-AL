package fr.esgi.al.use_cases.payment.domain;

import fr.esgi.al.kernel.Entity;

import java.util.Date;

public class Payment implements Entity<PaymentID> {
    private final PaymentID paymentID;
    private final float amount;
    private PaymentStatus paymentStatus;

    public Payment(PaymentID paymentID, float amount) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    @Override
    public PaymentID id() {
        return paymentID;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public float getAmount() {
        return amount;
    }
}
