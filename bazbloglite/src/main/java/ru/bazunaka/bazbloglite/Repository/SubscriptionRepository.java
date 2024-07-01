package ru.bazunaka.bazbloglite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.bazunaka.bazbloglite.Entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
