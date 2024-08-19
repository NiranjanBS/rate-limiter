package com.niranjan.ratelimit.repository;

import com.niranjan.ratelimit.model.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, Long> {

    UserSubscription getByUserId(String userId);
}
