package com.ivan.assignment.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PhoneDto {

    private int id;

    @JsonProperty("DeviceName")
    private String deviceName;

    @JsonProperty("Technology")
    private String technology;

    @JsonProperty("2g_bands")
    private String _2gBands;

    @JsonProperty("3g_bands")
    private String _3gBands;

    @JsonProperty("4g_bands")
    private String _4gBands;

    private String bookedUser;

    private Instant booked;

    @JsonProperty("available")
    public String available() {
        if (null == bookedUser) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
