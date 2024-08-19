package com.niranjan.ratelimit.controller;


import com.niranjan.ratelimit.dtos.RateLimitRequest;
import com.niranjan.ratelimit.service.RateLimitService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratelimit/")
@AllArgsConstructor
@Validated
public class RateLimitController {

    private final RateLimitService rateLimitService;

    @PostMapping("check")
    public ResponseEntity<String> check(@RequestBody @Valid RateLimitRequest request) {
        rateLimitService.check(request);
        return ResponseEntity.ok("Success");
    }
}
