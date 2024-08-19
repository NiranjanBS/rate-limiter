package com.niranjan.ratelimit.service;

import com.niranjan.ratelimit.model.Subscription;
import com.niranjan.ratelimit.enums.SubscriptionType;
import com.niranjan.ratelimit.repository.SubscriptionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepo subscriptionRepo;

    public Subscription getThrottle(SubscriptionType type) {
        Subscription defaultSub = getDefaultSubscription();
        return subscriptionRepo.getByType(type).orElse(defaultSub);
    }

    private static Subscription getDefaultSubscription() {
        Subscription defaultSub = new Subscription();
        defaultSub.setThrottle(10);
        defaultSub.setWindowInSecs(60);
        defaultSub.setType(SubscriptionType.BASIC);
        return defaultSub;
    }

    public Subscription getById(Long subscriptionId) {
        return subscriptionRepo.findById(subscriptionId).get();
    }
}
