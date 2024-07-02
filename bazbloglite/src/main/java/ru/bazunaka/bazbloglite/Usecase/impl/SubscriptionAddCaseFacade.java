package ru.bazunaka.bazbloglite.Usecase.impl;

import org.springframework.stereotype.Component;

import ru.bazunaka.bazbloglite.Entity.Subscription;
import ru.bazunaka.bazbloglite.Mapper.SubscribeRequestToSubscriptionMapper;
import ru.bazunaka.bazbloglite.Model.SubscribeRequest;
import ru.bazunaka.bazbloglite.Services.SubscriptionService;
import ru.bazunaka.bazbloglite.Usecase.SubscriptionAddCase;

@Component
public class SubscriptionAddCaseFacade implements SubscriptionAddCase {

    private final SubscribeRequestToSubscriptionMapper subscriptionMapper;
    private final SubscriptionService subscriptionService;

    public SubscriptionAddCaseFacade(SubscribeRequestToSubscriptionMapper subscriptionMapper,
                                    SubscriptionService subscriptionService) {
        this.subscriptionMapper = subscriptionMapper;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void subscribe(SubscribeRequest subscribeRequest) {
        Subscription subscription = this.subscriptionMapper.map(subscribeRequest);

        this.subscriptionService.createSubscribe(subscription);
    }

}
