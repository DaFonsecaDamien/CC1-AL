package fr.esgi.al.use_cases.credit_card.exposition;

import fr.esgi.al.use_cases.credit_card.domain.CreditCardID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreditCardRequest {

    @NotNull
    @NotBlank
    public String number;

    @NotNull
    public int securityCode;

    @NotNull
    @NotBlank
    public String ownerName;

    @NotNull
    public int membershipId;
}
