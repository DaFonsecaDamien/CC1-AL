package domain;

import kernel.Logger;

import java.util.function.Predicate;

public class MembershipInvalidValidator implements Predicate<Membership> {

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
