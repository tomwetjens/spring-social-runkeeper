/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.api;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FitnessActivityType {

    RUNNING("Running"),
    CYCLING("Cycling"),
    MOUNTAIN_BIKING("Mountain Biking"),
    WALKING("Walking"),
    HIKING("Hiking"),
    DOWNHILL_SKIING("Downhill Skiing"),
    CROSS_COUNTRY_SKIING("Cross-Country Skiing"),
    SNOWBOARDING("Snowboarding"),
    SKATING("Skating"),
    SWIMMING("Swimming"),
    WHEELCHAIR("Wheelchair"),
    ROWING("Rowing"),
    ELLIPTICAL("Elliptical"),
    OTHER("Other"),
    YOGA("Yoga"),
    PILATES("Pilates"),
    CROSS_FIT("CrossFit"),
    SPINNING("Spinning"),
    ZUMBA("Zumba"),
    BARRE("Barre"),
    GROUP_WORKOUT("Group Workout"),
    DANCE("Dance"),
    BOOTCAMP("Bootcamp"),
    BOXING("Boxing / MMA"),
    MEDITATION("Meditation"),
    STRENGTH_TRAINING("Strength Training"),
    CIRCUIT_TRAINING("Circuit Training"),
    CORE_STRENGTHENING("Core Strengthening"),
    ARC_TRAINER("Arc Trainer"),
    STAIRMASTER("Stairmaster / Stepwell"),
    SPORTS("Sports"),
    NORDIC_WALKING("Nordic Walking");

    private final String apiValue;

    FitnessActivityType(String apiValue) {
        this.apiValue = apiValue;
    }

    @JsonCreator
    public static FitnessActivityType fromApiValue(String apiValue) {
        for (FitnessActivityType value : values()) {
            if (value.apiValue.equalsIgnoreCase(apiValue)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown activity type: " + apiValue);
    }
}
