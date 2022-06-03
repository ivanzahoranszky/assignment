package com.ivan.assignment.controller.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

@Data
@Builder
public class BookingDto {

    private int id;

    private int phone;

    @Column("puser")
    private int user;

    @Column("started")
    private Instant start;

}
