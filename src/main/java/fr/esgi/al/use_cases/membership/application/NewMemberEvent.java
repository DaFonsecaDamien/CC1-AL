package fr.esgi.al.use_cases.membership.application;

import fr.esgi.al.kernel.ApplicationEvent;
import fr.esgi.al.use_cases.membership.domain.Membership;

public class NewMemberEvent implements ApplicationEvent {
    public final Membership membership;

    public NewMemberEvent(Membership membership) {
        super();
        this.membership = membership;
    }
}
