package fr.esgi.al.use_cases.membership.domain;

import fr.esgi.al.kernel.Logger;

import java.util.function.Predicate;

public final class MembershipInvalidValidator implements Predicate<Membership> {

    private final Logger logger;

    public MembershipInvalidValidator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean test(Membership membership) {
        logger.log("Membership Invalid");
        return false;
    }
}
