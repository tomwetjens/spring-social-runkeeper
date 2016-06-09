package org.springframework.social.runkeeper.api;

public interface HealthGraphOperations {

    User getUser();

    Profile getProfile();

    Feed<FitnessActivity> getFitnessActivities();

}
