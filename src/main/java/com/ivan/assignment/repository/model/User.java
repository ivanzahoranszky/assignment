package com.ivan.assignment.repository.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("puser")
public class User {

    @Id
    private int id;

    private String name;

}
