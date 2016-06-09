package org.springframework.social.runkeeper.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Profile {

    public static final String MEDIA_TYPE = "application/vnd.com.runkeeper.Profile+json";

    private String name;

    private String location;

    @JsonProperty("athlete_type")
    private String athleteType;

    private String gender;

    private String birthday;

    private boolean elite;

    private String profile;

    @JsonProperty("small_picture")
    private String smallPicture;

    @JsonProperty("normal_picture")
    private String normalPicture;

    @JsonProperty("medium_picture")
    private String mediumPicture;

    @JsonProperty("large_picture")
    private String largePicture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAthleteType() {
        return athleteType;
    }

    public void setAthleteType(String athleteType) {
        this.athleteType = athleteType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isElite() {
        return elite;
    }

    public void setElite(boolean elite) {
        this.elite = elite;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSmallPicture() {
        return smallPicture;
    }

    public void setSmallPicture(String smallPicture) {
        this.smallPicture = smallPicture;
    }

    public String getNormalPicture() {
        return normalPicture;
    }

    public void setNormalPicture(String normalPicture) {
        this.normalPicture = normalPicture;
    }

    public String getMediumPicture() {
        return mediumPicture;
    }

    public void setMediumPicture(String mediumPicture) {
        this.mediumPicture = mediumPicture;
    }

    public String getLargePicture() {
        return largePicture;
    }

    public void setLargePicture(String largePicture) {
        this.largePicture = largePicture;
    }
}
