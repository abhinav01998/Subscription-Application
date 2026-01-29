package com.sub.project.repository;

import com.sub.project.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
    // Finds all the subscriptions equaling the renewal date provided
    List<Subscription> findByNextRenewalDate(LocalDate nextRenewalDate);
}
