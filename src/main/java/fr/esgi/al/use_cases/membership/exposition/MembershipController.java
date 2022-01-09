package fr.esgi.al.use_cases.membership.exposition;

import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.QueryBus;
import fr.esgi.al.use_cases.contractor.application.CreateContractor;
import fr.esgi.al.use_cases.contractor.exposition.ContractorRequest;
import fr.esgi.al.use_cases.membership.application.RetrieveMemberships;
import fr.esgi.al.use_cases.membership.domain.Membership;
import fr.esgi.al.use_cases.membership.domain.MembershipID;
import fr.esgi.al.use_cases.tradesman.application.CreateTradesman;
import fr.esgi.al.use_cases.tradesman.exposition.TradesmanRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class MembershipController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public MembershipController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/memberships", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MembershipsResponse> getAll() {
        final List<Membership> members = queryBus.send(new RetrieveMemberships());
        MembershipsResponse membershipsResponseResult = new MembershipsResponse(members.stream().map(member -> new MembershipResponse(String.valueOf(member.getId().getValue()), member.getLastname(), member.getFirstname())).collect(Collectors.toList()));
        return ResponseEntity.ok(membershipsResponseResult);
    }

    @PostMapping(path = "/memberships/tradesman", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid TradesmanRequest request) {
        CreateTradesman createTradesman = new CreateTradesman(request.lastname, request.firstname, request.email, request.password);
        MembershipID membershipId = commandBus.send(createTradesman);
        return ResponseEntity.created(URI.create("/memberships/" + membershipId.getValue())).build();
    }

    @PostMapping(path = "/memberships/contractor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid ContractorRequest request) {
        CreateContractor createContractor = new CreateContractor(request.lastname, request.firstname, request.email, request.password);
        MembershipID membershipId = commandBus.send(createContractor);
        return ResponseEntity.created(URI.create("/memberships/" + membershipId.getValue())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
