/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.api.internal;

import org.springframework.web.client.RestTemplate;

import com.wetjens.springframework.social.runkeeper.api.Feed;
import com.wetjens.springframework.social.runkeeper.api.FitnessActivity;
import com.wetjens.springframework.social.runkeeper.api.HealthGraphOperations;
import com.wetjens.springframework.social.runkeeper.api.Profile;
import com.wetjens.springframework.social.runkeeper.api.User;

public class HealthGraphTemplate implements HealthGraphOperations {

    private static final String API_BASE_URI = "https://api.runkeeper.com";

    private final RestTemplate restTemplate;

    private User user;
    private Profile profile;

    public HealthGraphTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUser() {
        if (user == null) {
            user = restTemplate.getForObject(API_BASE_URI + "/user", User.class);
        }
        return user;
    }

    public Profile getProfile() {
        if (profile == null) {
            profile = restTemplate.getForObject(API_BASE_URI + getUser().getProfile(), Profile.class);
        }
        return profile;
    }

    public Feed<FitnessActivity> getFitnessActivities() {
        return new FitnessActivityFeed(restTemplate, API_BASE_URI, getUser());
    }
}
