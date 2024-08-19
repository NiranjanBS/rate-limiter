package com.niranjan.ratelimit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity(name = "UserRequest")
public class UserRequest {

    @Id
    @GeneratedValue
    private long id;
    private String userId;
    private String apiEndPoint;
    private LocalDateTime requestTime;

}
