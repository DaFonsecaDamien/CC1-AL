package fr.esgi.al.use_cases.membership.domain;

public class Password {
    private final String value;

    public Password(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
