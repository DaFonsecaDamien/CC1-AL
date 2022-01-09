package fr.esgi.al.use_cases.credit_card.exposition;

import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.QueryBus;
import fr.esgi.al.use_cases.credit_card.application.CreateCreditCard;
import fr.esgi.al.use_cases.credit_card.application.RetrieveCreditCards;
import fr.esgi.al.use_cases.credit_card.domain.CreditCard;
import fr.esgi.al.use_cases.credit_card.domain.CreditCardID;
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
public class CreditCardController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public CreditCardController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/credit-cards", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreditCardsResponse> getAll() {
        final List<CreditCard> creditCards = queryBus.send(new RetrieveCreditCards());
        CreditCardsResponse creditCardsResponseResult = new CreditCardsResponse(creditCards.stream().map(creditCard -> new CreditCardResponse(String.valueOf(creditCard.getId().getValue()), creditCard.getNumber(), creditCard.getSecurityCode(), creditCard.getOwnerName())).collect(Collectors.toList()));
        return ResponseEntity.ok(creditCardsResponseResult);
    }

    @PostMapping(path = "/credit-cards", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid CreditCardRequest request) {
        CreateCreditCard createCreditCard = new CreateCreditCard(request.number,request.securityCode,request.ownerName,request.membershipId);
        CreditCardID creditCardID = commandBus.send(createCreditCard);
        return ResponseEntity.created(URI.create("/credit-cards/" + creditCardID.getValue())).build();
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
