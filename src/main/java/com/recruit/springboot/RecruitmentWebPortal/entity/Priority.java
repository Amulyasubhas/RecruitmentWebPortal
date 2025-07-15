package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private final String label;

    Priority(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static Priority forValue(String value) {
        for (Priority p : values()) {
            if (p.label.equalsIgnoreCase(value.trim())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid Priority value: " + value);
    }
}
