/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.api;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FitnessActivity {

    public static final String MEDIA_TYPE = "application/vnd.com.runkeeper.FitnessActivity+json";

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("utc_offset")
    private Integer utcOffset;

    private FitnessActivityType type;

    private String uri;

    public FitnessActivityType getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public Integer getUtcOffset() {
        return utcOffset;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
