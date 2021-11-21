package infrastructure;

import kernel.ApplicationLogger;
import kernel.Logger;

public class StubPaymentService implements PaymentService{

    private final Logger logger;

    public StubPaymentService(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean process() {
        logger.log("Payment Processed");
        return true;
    }
}
