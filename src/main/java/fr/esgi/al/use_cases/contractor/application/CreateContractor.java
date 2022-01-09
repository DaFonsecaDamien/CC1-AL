package fr.esgi.al.use_cases.contractor.application;

import fr.esgi.al.kernel.Command;
import fr.esgi.al.use_cases.membership.domain.Email;
import fr.esgi.al.use_cases.membership.domain.Password;

/**
 * Command object
 */
@SuppressWarnings("all")
public class CreateContractor implements Command {

    public final String lastname;
    public final String firstname;
    public final Email email;
    public final Password password;

    public CreateContractor(String lastname, String firstname, Email email, Password password) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }
}
