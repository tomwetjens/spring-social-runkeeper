package org.springframework.social.runkeeper.connect.internal;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.runkeeper.api.Profile;
import org.springframework.social.runkeeper.api.Runkeeper;
import org.springframework.social.runkeeper.api.User;

public class RunkeeperAdapter implements ApiAdapter<Runkeeper> {

    public boolean test(Runkeeper runkeeper) {
        try {
            User user = runkeeper.healthGraph().getUser();
            return user != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void setConnectionValues(Runkeeper runkeeper, ConnectionValues connectionValues) {
        User user = runkeeper.healthGraph().getUser();
        connectionValues.setProviderUserId(user.getUserID().toString());

        Profile profile = runkeeper.healthGraph().getProfile();
        connectionValues.setProfileUrl(profile.getProfile());
        connectionValues.setImageUrl(profile.getNormalPicture());
        connectionValues.setDisplayName(profile.getName());
    }

    public UserProfile fetchUserProfile(Runkeeper runkeeper) {
        User user = runkeeper.healthGraph().getUser();
        Profile profile = runkeeper.healthGraph().getProfile();
        return new UserProfile(user.getUserID().toString(), profile.getName(), null, null, null, null);
    }

    public void updateStatus(Runkeeper runkeeper, String statusMessage) {

    }

}
