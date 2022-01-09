package fr.esgi.al;

import fr.esgi.al.kernel.*;
import fr.esgi.al.use_cases.contractor.application.CreateContractor;
import fr.esgi.al.use_cases.contractor.application.CreateContractorCommandHandler;
import fr.esgi.al.use_cases.contractor.application.CreateContractorEvent;
import fr.esgi.al.use_cases.contractor.application.CreateContractorEventListener;
import fr.esgi.al.use_cases.contractor.domain.ContractorRepository;
import fr.esgi.al.use_cases.credit_card.application.*;
import fr.esgi.al.use_cases.credit_card.domain.CreditCardRepository;
import fr.esgi.al.use_cases.credit_card.infrastructure.InMemoryCreditCardsRepository;
import fr.esgi.al.use_cases.email.application.StubMailService;
import fr.esgi.al.use_cases.email.infrastructure.MailService;
import fr.esgi.al.use_cases.membership.application.*;
import fr.esgi.al.use_cases.membership.domain.MembershipRepository;
import fr.esgi.al.use_cases.membership.infrastructure.InMemoryMembershipRepository;
import fr.esgi.al.use_cases.payment.application.StubPaymentService;
import fr.esgi.al.use_cases.payment.domain.PaymentRepository;
import fr.esgi.al.use_cases.payment.infrastructure.InMemoryPaymentRepository;
import fr.esgi.al.use_cases.payment.infrastructure.PaymentService;
import fr.esgi.al.use_cases.subscription.application.ProcessSubscriptionPayment;
import fr.esgi.al.use_cases.subscription.application.ProcessSubscriptionPaymentHandler;
import fr.esgi.al.use_cases.tradesman.application.CreateTradesman;
import fr.esgi.al.use_cases.tradesman.application.CreateTradesmanCommandHandler;
import fr.esgi.al.use_cases.tradesman.application.CreateTradesmanEvent;
import fr.esgi.al.use_cases.tradesman.application.CreateTradesmanEventListener;
import fr.esgi.al.use_cases.tradesman.domain.TradesmanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Logger logger() {
        return new ApplicationLogger();
    }

    @Bean
    public PaymentService paymentService() {
        return new StubPaymentService(applicationLogger());
    }

    @Bean
    public PaymentRepository paymentRepository() {
        return new InMemoryPaymentRepository();
    }

    @Bean
    public MembershipRepository membershipRepository() {
        return new InMemoryMembershipRepository();
    }

    @Bean
    public CreditCardRepository creditCardRepository() {
        return new InMemoryCreditCardsRepository();
    }

    @Bean
    public ApplicationLogger applicationLogger() {
        return new ApplicationLogger();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateTradesmanEvent.class, List.of(new CreateTradesmanEventListener()));
        listenerMap.put(CreateContractorEvent.class, List.of(new CreateContractorEventListener()));
        listenerMap.put(CreateCreditCardEvent.class, List.of(new CreateCreditCardEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateTradesmanCommandHandler createTradesmanCommandHandler() {
        return new CreateTradesmanCommandHandler(membershipRepository(), eventEventDispatcher());
    }

    @Bean
    public CreateContractorCommandHandler createContractorCommandHandler() {
        return new CreateContractorCommandHandler(membershipRepository(), eventEventDispatcher());
    }

    @Bean
    public CreateCreditCardCommandHandler createCreditCardCommandHandler() {
        return new CreateCreditCardCommandHandler(creditCardRepository(), eventEventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateTradesman.class, new CreateTradesmanCommandHandler(membershipRepository(), eventEventDispatcher()));
        commandHandlerMap.put(CreateContractor.class, new CreateContractorCommandHandler(membershipRepository(), eventEventDispatcher()));
        commandHandlerMap.put(CreateCreditCard.class, new CreateCreditCardCommandHandler(creditCardRepository(), eventEventDispatcher()));
        commandHandlerMap.put(ProcessSubscriptionPayment.class, new ProcessSubscriptionPaymentHandler(logger()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(RetrieveMemberships.class, new RetrieveMembershipsHandler(membershipRepository()));
        queryHandlerMap.put(RetrieveCreditCards.class, new RetrieveCreditCardsHandler(creditCardRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveMembershipsHandler retrieveMembershipsHandler() {
        return new RetrieveMembershipsHandler(membershipRepository());
    }

    @Bean
    public RetrieveCreditCardsHandler retrieveCreditCardsHandler() {
        return new RetrieveCreditCardsHandler(creditCardRepository());
    }

    @Bean
    public MailService mailService() {
        return new StubMailService(applicationLogger());
    }

}
