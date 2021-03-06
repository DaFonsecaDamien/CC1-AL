package fr.esgi.al.use_cases.email.domain;

public class Mail {
    private final String body;
    private final String subject;

    public Mail(String body, String subject) {
        this.body = body;
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }
}
