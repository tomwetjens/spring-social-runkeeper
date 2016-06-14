/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.api;

public interface HealthGraphOperations {

    User getUser();

    Profile getProfile();

    Feed<FitnessActivity> getFitnessActivities();
}
