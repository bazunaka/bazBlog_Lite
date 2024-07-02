package ru.bazunaka.bazbloglite.Services;

import ru.bazunaka.bazbloglite.Entity.Subscription;

public interface SubscriptionService {

    void createSubscribe(Subscription subscription);

    void deleteSubscribe(Subscription subscription);

    boolean existSubscription(Subscription subscription);

}
