package org.springframework.social.runkeeper.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.runkeeper.api.Runkeeper;
import org.springframework.social.runkeeper.connect.internal.RunkeeperAdapter;
import org.springframework.social.runkeeper.connect.internal.RunkeeperServiceProvider;

public class RunkeeperConnectionFactory extends OAuth2ConnectionFactory<Runkeeper> {

    public static final String PROVIDER_ID = "runkeeper";

    public RunkeeperConnectionFactory(String clientId, String clientSecret) {
        super(PROVIDER_ID, new RunkeeperServiceProvider(clientId, clientSecret), new RunkeeperAdapter());
    }

}
