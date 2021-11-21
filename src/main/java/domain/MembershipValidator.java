package domain;

import kernel.Logger;

import java.util.function.Predicate;

public class MembershipValidator implements Predicate<Membership> {

    private final Logger logger;

    public MembershipValidator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean test(Membership membership) {
        logger.log("Membership Valid");
        return true;
    }
}
