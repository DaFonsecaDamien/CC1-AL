package fr.esgi.al.use_cases.credit_card.exposition;

import fr.esgi.al.use_cases.credit_card.domain.CreditCardID;
import fr.esgi.al.use_cases.membership.domain.MembershipID;

@SuppressWarnings("all")
public class CreditCardResponse {

    public String id;
    public String number;
    public int securityCode;
    public String ownerName;

    public CreditCardResponse(String id, String number, int securityCode, String ownerName) {
        this.id = id;
        this.number = number;
        this.securityCode = securityCode;
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "CreditCardDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
