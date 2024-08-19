package com.niranjan.ratelimit.service;

import com.niranjan.ratelimit.dtos.RateLimitRequest;
import com.niranjan.ratelimit.exception.RateLimitException;
import com.niranjan.ratelimit.model.Subscription;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RateLimitService {

    private final UserRequestService userRequestService;
    private final UserSubscriptionService userSubscriptionService;

    public void check(RateLimitRequest request) {
        Subscription subscription = userSubscriptionService.getUserSubscription(request.getUserId());
        LocalDateTime startTime = LocalDateTime.now().minusSeconds(subscription.getWindowInSecs());
        int requestCount = userRequestService.getRequestCount(request, startTime);
        if (requestCount >= subscription.getThrottle()) {
            throw new RateLimitException(HttpStatusCode.valueOf(429), "Too many requests, upgrade your subscription");
        }
        userRequestService.save(request);
    }

}
