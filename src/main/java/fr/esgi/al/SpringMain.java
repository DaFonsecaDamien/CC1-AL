package fr.esgi.al;

import fr.esgi.al.domain.Project;
import fr.esgi.al.domain.ProjectID;
import fr.esgi.al.use_cases.contractor.application.CreateContractor;
import fr.esgi.al.use_cases.contractor.application.CreateContractorCommandHandler;
import fr.esgi.al.use_cases.membership.application.RetrieveMemberships;
import fr.esgi.al.use_cases.membership.application.RetrieveMembershipsHandler;
import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);
    }
}
