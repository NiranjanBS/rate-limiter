package com.niranjan.ratelimit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "UserSubscription")
public class UserSubscription {

    @Id
    @GeneratedValue
    private Long id;
    private String userId;
    private String apiEndPoint;
    private Long subscriptionId;

}
