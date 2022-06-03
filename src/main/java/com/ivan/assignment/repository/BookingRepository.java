package com.ivan.assignment.repository;

import com.ivan.assignment.repository.model.Booking;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface BookingRepository extends ReactiveCrudRepository<Booking, Integer> {
    @Query("""
            SELECT id, phone, puser FROM booking WHERE phone = :phoneId 
           """)
    Mono<Booking> findByPhoneId(int phoneId);
}
