package fr.esgi.al.use_cases.membership.domain;

import fr.esgi.al.kernel.Logger;

import java.util.function.Predicate;

public final class MembershipValidator implements Predicate<Membership> {

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
