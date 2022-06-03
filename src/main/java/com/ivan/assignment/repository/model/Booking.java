package com.ivan.assignment.repository.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

@Data
@Builder
public class Booking {

    @Id
    private int id;

    private int phone;

    @Column("puser")
    private int user;

    @Column("started")
    private Instant start;

}
