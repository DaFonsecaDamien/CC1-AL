package fr.esgi.al.use_cases.membership.domain;

public class Email {
    private final String value;

    public Email(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
