import domain.*;
import infrastructure.InMemoryMembershipRepository;
import infrastructure.MembershipController;
import infrastructure.MembershipService;
import infrastructure.StubPaymentService;
import kernel.ApplicationLogger;

public class Main {
    public static void main(String[] args) {
        var logger = new ApplicationLogger();
        var membershipValid = new MembershipValidator(logger);
        var membershipInvalid = new MembershipInvalidValidator(logger);

        var paymentService = new StubPaymentService(logger);
        var membershipRepository = new InMemoryMembershipRepository();

        var membershipValidService = new MembershipService(membershipRepository, membershipValid, paymentService);
        var membershipValidController = new MembershipController(membershipValidService);
        membershipValidController.addFromRequest(Membership.of("Damien","Da Fonseca"));

        var membershipInvalidService = new MembershipService(membershipRepository, membershipInvalid, paymentService);
        var membershipInvalidController = new MembershipController(membershipInvalidService);
        membershipInvalidController.addFromRequest(Membership.of("Theo","Douglas"));
    }
}
