package com.niranjan.ratelimit.repository;

import com.niranjan.ratelimit.model.Subscription;
import com.niranjan.ratelimit.enums.SubscriptionType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

    Optional<Subscription> getByType(SubscriptionType type);
}
