package fr.esgi.al.use_cases.credit_card.exposition;

import fr.esgi.al.use_cases.membership.exposition.MembershipResponse;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("all")
@XmlRootElement
public class CreditCardsResponse {
    public final List<CreditCardResponse> creditCards;

    public CreditCardsResponse(List<CreditCardResponse> creditCards) {
        this.creditCards = creditCards;
    }
}
