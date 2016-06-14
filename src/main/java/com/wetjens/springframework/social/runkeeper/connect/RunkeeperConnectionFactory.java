/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.wetjens.springframework.social.runkeeper.api.Runkeeper;
import com.wetjens.springframework.social.runkeeper.connect.internal.RunkeeperAdapter;
import com.wetjens.springframework.social.runkeeper.connect.internal.RunkeeperServiceProvider;

public class RunkeeperConnectionFactory extends OAuth2ConnectionFactory<Runkeeper> {

    public static final String PROVIDER_ID = "runkeeper";

    public RunkeeperConnectionFactory(String clientId, String clientSecret) {
        super(PROVIDER_ID, new RunkeeperServiceProvider(clientId, clientSecret), new RunkeeperAdapter());
    }
}
