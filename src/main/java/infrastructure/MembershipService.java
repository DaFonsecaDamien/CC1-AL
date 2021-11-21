package infrastructure;

import domain.Membership;

import java.util.function.Predicate;

public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final Predicate<Membership> membershipValidator;
    private final PaymentService paymentService;

    public MembershipService(MembershipRepository membershipRepository, Predicate<Membership> membershipValidator, PaymentService paymentService) {
        this.membershipRepository = membershipRepository;
        this.membershipValidator = membershipValidator;
        this.paymentService = paymentService;
    }

    void addMembership(Membership membership){
        if(membershipValidator.test(membership) && paymentService.process()){
            membershipRepository.add(membership);
        }
    }

}
