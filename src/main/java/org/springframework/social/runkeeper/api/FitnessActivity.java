package org.springframework.social.runkeeper.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

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
