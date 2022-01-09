package fr.esgi.al.use_cases.credit_card.domain;

import fr.esgi.al.kernel.Entity;
import fr.esgi.al.use_cases.membership.domain.MembershipID;

public final class CreditCard implements Entity<CreditCardID> {

    private final CreditCardID creditCardId;
    private final String number;
    private final int securityCode;
    private final String ownerName;

    public CreditCard(CreditCardID creditCardId, String number, int securityCode, String ownerName) {
        this.creditCardId = creditCardId;
        this.number = number;
        this.securityCode = securityCode;
        this.ownerName = ownerName;
    }

    public CreditCardID getId() {
        return creditCardId;
    }

    public String getNumber() {
        return number;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public CreditCardID id() {
        return creditCardId;
    }
}
