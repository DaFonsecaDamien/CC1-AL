package fr.esgi.al.use_cases.membership.application;

import fr.esgi.al.kernel.EventListener;
import fr.esgi.al.use_cases.email.domain.Mail;
import fr.esgi.al.use_cases.email.infrastructure.MailService;

public class ProcessEmailEventListener implements EventListener<NewMemberEvent> {
    private final MailService mailService;

    public ProcessEmailEventListener(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void listenTo(NewMemberEvent event) {
        mailService.sendMail(new Mail("Welcome " + event.membership.getLastname(),
                "Register with email " + event.membership.getEmail()), event.membership);
    }
}
