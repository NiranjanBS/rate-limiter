package com.niranjan.ratelimit.model;

import com.niranjan.ratelimit.enums.SubscriptionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Subscription")
public class Subscription {

    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    private SubscriptionType type;
    @Column(name = "WINDOW_IN_SECS")
    private int windowInSecs;
    private int throttle;

}
