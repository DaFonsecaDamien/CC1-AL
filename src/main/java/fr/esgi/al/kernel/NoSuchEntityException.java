package fr.esgi.al.kernel;

import fr.esgi.al.use_cases.membership.domain.MembershipID;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(MembershipID id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }
}
