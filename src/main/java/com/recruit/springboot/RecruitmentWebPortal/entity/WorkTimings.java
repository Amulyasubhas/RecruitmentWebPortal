package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WorkTimings {
    NINE_AM_TO_SIX_PM("9 AM - 6 PM"),
    ELEVEN_AM_TO_EIGHT_PM("11 AM - 8 PM"),
    TWO_PM_TO_ELEVEN_PM("2 PM - 11 PM"),
    NINE_THIRTY_AM_TO_SIX_THIRTY_PM("9:30 AM - 6:30 PM");

    private final String label;

    WorkTimings(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static WorkTimings forValue(String value) {
        for (WorkTimings timing : WorkTimings.values()) {
            if (timing.label.equalsIgnoreCase(value.trim())) {
                return timing;
            }
        }
        throw new IllegalArgumentException("Invalid WorkTimings label: " + value);
    }
}
