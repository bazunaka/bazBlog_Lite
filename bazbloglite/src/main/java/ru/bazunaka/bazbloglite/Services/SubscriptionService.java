package ru.bazunaka.bazbloglite.Services;

import ru.bazunaka.bazbloglite.Entity.Subscription;

public interface SubscriptionService {

    void subscribe(Subscription subscription);

    void unsubscribe(Subscription subscription);

    boolean existSubscription(Subscription subscription);

}
