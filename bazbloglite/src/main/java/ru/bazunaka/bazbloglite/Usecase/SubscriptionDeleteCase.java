package ru.bazunaka.bazbloglite.Usecase;

import ru.bazunaka.bazbloglite.Model.SubscribeRequest;
import ru.bazunaka.bazbloglite.Model.UnsubscribeRequest;

public interface SubscriptionDeleteCase {

    void unsubscribe(UnsubscribeRequest unsubscribeRequest);

}
