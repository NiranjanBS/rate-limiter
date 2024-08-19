package com.niranjan.ratelimit.repository;

import com.niranjan.ratelimit.model.UserRequest;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestRepo extends JpaRepository<UserRequest, Long> {

    int countByUserIdAndApiEndPointAndRequestTimeAfter(String userId, String apiEndPoint, LocalDateTime requestTime);

}
