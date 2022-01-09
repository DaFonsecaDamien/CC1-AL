package fr.esgi.al.use_cases.subscription.application;

import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Logger;
public class ProcessSubscriptionPaymentHandler implements CommandHandler<ProcessSubscriptionPayment, Void> {
    private final Logger logger;

    public ProcessSubscriptionPaymentHandler(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Void handle(ProcessSubscriptionPayment command) {
        logger.log("Processing subscription payment");
        return null;
    }
}
