package fr.esgi.al.use_cases.payment.infrastructure;

import fr.esgi.al.kernel.NoSuchEntityException;
import fr.esgi.al.use_cases.payment.domain.Payment;
import fr.esgi.al.use_cases.payment.domain.PaymentID;
import fr.esgi.al.use_cases.payment.domain.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryPaymentRepository implements PaymentRepository {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<PaymentID, Payment> data = new ConcurrentHashMap<>();

    @Override
    public PaymentID nextIdentity() {
        return new PaymentID(counter.incrementAndGet());
    }

    @Override
    public Payment findById(PaymentID paymentId) throws NoSuchEntityException {
        return data.get(paymentId);
    }

    @Override
    public void add(Payment payment) {
        data.put(payment.id(), payment);
    }

    @Override
    public void delete(PaymentID id) {
        data.remove(id);
    }

    @Override
    public List<Payment> findAll() {
        return List.copyOf(data.values());
    }
}
