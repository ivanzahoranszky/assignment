package com.ivan.assignment.repository;

import com.ivan.assignment.repository.model.Phone;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PhoneRepository extends ReactiveCrudRepository<Phone, Integer> {

    @Query("""
            SELECT phone.id, phone.device_name, puser.name booked_user, booking.started booked FROM phone 
                LEFT JOIN booking ON booking.phone = phone.id
                LEFT JOIN puser ON puser.id = booking.puser
           """)
    Flux<Phone> findPhones();

    @Query("""
            SELECT phone.id, phone.device_name, puser.name booked_user, booking.started booked FROM phone 
                LEFT JOIN booking ON booking.phone = phone.id
                LEFT JOIN puser ON puser.id = booking.puser 
                WHERE NOT EXISTS (SELECT 1 FROM booking WHERE phone.id = booking.phone);
           """)
    Flux<Phone> findFreePhones();

}
