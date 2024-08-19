package com.niranjan.ratelimit.service;

import com.niranjan.ratelimit.model.Subscription;
import com.niranjan.ratelimit.enums.SubscriptionType;
import com.niranjan.ratelimit.model.UserSubscription;
import com.niranjan.ratelimit.repository.UserSubscriptionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSubscriptionService {

    private final UserSubscriptionRepo userSubscriptionRepo;
    private final SubscriptionService subscriptionService;

    public Subscription getUserSubscription(String userId) {
        UserSubscription subscription = userSubscriptionRepo.getByUserId(userId);
        if (subscription == null) {
            //return basic version
            return subscriptionService.getThrottle(SubscriptionType.BASIC);
        }
        return subscriptionService.getById(subscription.getSubscriptionId());
    }
}
