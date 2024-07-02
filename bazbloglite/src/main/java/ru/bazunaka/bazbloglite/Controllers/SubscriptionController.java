package ru.bazunaka.bazbloglite.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ru.bazunaka.bazbloglite.Model.SubscribeRequest;
import ru.bazunaka.bazbloglite.Model.UnsubscribeRequest;
import ru.bazunaka.bazbloglite.Usecase.SubscriptionAddCase;
import ru.bazunaka.bazbloglite.Usecase.SubscriptionDeleteCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionAddCase subscriptionAddCase;
    private final SubscriptionDeleteCase subscriptionDeleteCase;

    public SubscriptionController(SubscriptionAddCase subscriptionAddCase,
                                SubscriptionDeleteCase subscriptionDeleteCase) {
        this.subscriptionAddCase = subscriptionAddCase;
        this.subscriptionDeleteCase = subscriptionDeleteCase;
    }

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody SubscribeRequest subscribeRequest) {
        this.subscriptionAddCase.subscribe(subscribeRequest);
    }
    
    @PostMapping("/unsubscribe")
    public void unsubscribe(@Valid @RequestBody UnsubscribeRequest unsubscribeRequest) {
        this.subscriptionDeleteCase.unsubscribe(unsubscribeRequest);
    }
}
