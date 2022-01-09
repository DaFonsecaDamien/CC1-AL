package fr.esgi.al.use_cases.email.application;

import fr.esgi.al.kernel.Logger;
import fr.esgi.al.use_cases.email.domain.Mail;
import fr.esgi.al.use_cases.email.infrastructure.MailService;
import fr.esgi.al.use_cases.membership.domain.Membership;

public class StubMailService implements MailService {
    private final Logger logger;

    public StubMailService(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void sendMail(Mail mail, Membership membership) {
        logger.log("Sending mail : " + mail.getSubject() +
                        "{ " + mail.getBody() + " }" +
                "to : " + membership.getEmail().getValue());
    }
}
