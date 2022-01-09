package fr.esgi.al.use_cases.email.infrastructure;

import fr.esgi.al.use_cases.email.domain.Mail;
import fr.esgi.al.use_cases.membership.domain.Membership;

public interface MailService {
    void sendMail(Mail mail, Membership membership);
}
