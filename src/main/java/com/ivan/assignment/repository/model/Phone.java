package com.ivan.assignment.repository.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@Builder
public class Phone {

    public enum Technology {
        IOS,
        ANDROID,
        WINDOWS,
        UNKNOWN
    }

    public enum Availability {
        YES,
        NO
    }

    @Id
    private int id;

    @JsonProperty("DeviceName")
    private String deviceName;

    @JsonProperty("Technology")
    private Technology technology;

    @JsonProperty("2g_bands")
    private String _2gBands;

    @JsonProperty("3g_bands")
    private String _3gBands;

    @JsonProperty("4g_bands")
    private String _4gBands;

    private String bookedUser;

    private Instant booked;

    @JsonProperty("available")
    public Availability available() {
        if (null == bookedUser) {
            return Availability.YES;
        } else {
            return Availability.NO;
        }
    }
}
