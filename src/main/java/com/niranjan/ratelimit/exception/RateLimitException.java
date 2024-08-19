package com.niranjan.ratelimit.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class RateLimitException extends RuntimeException {

    private final HttpStatusCode statusCode;

    public RateLimitException(HttpStatusCode statusCode, String s) {
        super(s);
        this.statusCode = statusCode;
    }
}
