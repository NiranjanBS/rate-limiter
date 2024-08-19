package com.niranjan.ratelimit.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RateLimitRequest {

    @NotNull
    private String userId;
    @NotNull
    private String apiEndPoint;

}
