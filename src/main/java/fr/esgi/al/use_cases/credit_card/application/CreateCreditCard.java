package fr.esgi.al.use_cases.credit_card.application;

import fr.esgi.al.kernel.Command;

public class CreateCreditCard implements Command {

    public final String number;
    public final int securityCode;
    public final String ownerName;
    public final int membershipId;

    public CreateCreditCard(String number, int securityCode, String ownerName, int membershipId) {
        this.number = number;
        this.securityCode = securityCode;
        this.ownerName = ownerName;
        this.membershipId = membershipId;
    }
}
