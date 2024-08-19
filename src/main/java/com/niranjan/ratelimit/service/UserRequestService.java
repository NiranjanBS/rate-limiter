package com.niranjan.ratelimit.service;

import com.niranjan.ratelimit.dtos.RateLimitRequest;
import com.niranjan.ratelimit.model.UserRequest;
import com.niranjan.ratelimit.repository.UserRequestRepo;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRequestService {

    private final UserRequestRepo userRequestRepo;

    public int getRequestCount(RateLimitRequest request, LocalDateTime startTime) {
        return userRequestRepo.countByUserIdAndApiEndPointAndRequestTimeAfter(request.getUserId(),
            request.getApiEndPoint(), startTime);
    }

    public void save(RateLimitRequest request) {
        userRequestRepo.save(userRequest(request));
    }

    private UserRequest userRequest(RateLimitRequest request) {
        UserRequest userRequest = new UserRequest();
        userRequest.setRequestTime(LocalDateTime.now());
        userRequest.setUserId(request.getUserId());
        userRequest.setApiEndPoint(request.getApiEndPoint());
        return userRequest;
    }
}
