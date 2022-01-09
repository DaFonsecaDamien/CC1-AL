package fr.esgi.al.use_cases.tradesman.domain;

import fr.esgi.al.domain.Skill;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.membership.application.MembershipDTO;
import fr.esgi.al.use_cases.membership.domain.Email;
import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipID;
import fr.esgi.al.use_cases.membership.domain.Password;
import fr.esgi.al.use_cases.payment.domain.Payment;
import fr.esgi.al.use_cases.subscription.domain.Subscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Tradesman extends Membership {
    private final List<Skill> skills;

    public Tradesman(MembershipID id, String firstname, String lastname, Email email, Password password) {
        super(id, firstname, lastname, email, password);
        this.skills = new ArrayList<>();
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
