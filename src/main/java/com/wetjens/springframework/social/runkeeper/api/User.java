/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    public static final String MEDIA_TYPE = "application/vnd.com.runkeeper.User+json";

    private Integer userID;

    @JsonProperty("fitness_activities")
    private String fitnessActivities;

    private String profile;

    public Integer getUserID() {
        return userID;
    }

    public String getFitnessActivities() {
        return fitnessActivities;
    }

    public String getProfile() {
        return profile;
    }
}
