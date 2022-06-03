package com.ivan.assignment.repository;

import com.ivan.assignment.repository.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

    @Query("SELECT id, name FROM puser WHERE name = :userName")
    Mono<User> findByName(@Param("userName") String userName);

}
