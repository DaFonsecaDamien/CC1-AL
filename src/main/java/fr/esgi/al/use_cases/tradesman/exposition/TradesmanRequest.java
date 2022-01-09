package fr.esgi.al.use_cases.tradesman.exposition;

import fr.esgi.al.use_cases.membership.domain.Email;
import fr.esgi.al.use_cases.membership.domain.Password;
import fr.esgi.al.use_cases.membership.exposition.MembershipRequest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TradesmanRequest extends MembershipRequest {
    @NotNull
    @NotBlank
    public Email email;
    @NotNull
    @NotBlank
    public Password password;
}
