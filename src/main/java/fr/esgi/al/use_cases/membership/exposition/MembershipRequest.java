package fr.esgi.al.use_cases.membership.exposition;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public abstract class MembershipRequest {
    @NotNull
    @NotBlank
    public String lastname;

    @NotNull
    @NotBlank
    public String firstname;
}
