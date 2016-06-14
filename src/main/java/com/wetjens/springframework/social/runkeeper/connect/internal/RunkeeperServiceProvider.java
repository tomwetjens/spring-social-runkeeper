/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.connect.internal;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import com.wetjens.springframework.social.runkeeper.api.Runkeeper;
import com.wetjens.springframework.social.runkeeper.api.internal.RunkeeperTemplate;

public class RunkeeperServiceProvider extends AbstractOAuth2ServiceProvider<Runkeeper> {

    public static final String AUTHORIZE_URL = "https://runkeeper.com/apps/authorize";
    public static final String ACCESS_TOKEN_URL = "https://runkeeper.com/apps/token";

    public RunkeeperServiceProvider(String clientId, String clientSecret) {
        super(createOAuth2Template(clientId, clientSecret));
    }

    private static OAuth2Template createOAuth2Template(String clientId, String clientSecret) {
        OAuth2Template oAuth2Template = new OAuth2Template(clientId, clientSecret, AUTHORIZE_URL, ACCESS_TOKEN_URL);
        oAuth2Template.setUseParametersForClientAuthentication(true);
        return oAuth2Template;
    }

    public Runkeeper getApi(String accessToken) {
        return new RunkeeperTemplate(accessToken);
    }
}
