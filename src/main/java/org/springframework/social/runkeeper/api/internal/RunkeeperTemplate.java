package org.springframework.social.runkeeper.api.internal;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.runkeeper.api.*;

import java.util.Arrays;
import java.util.List;

public class RunkeeperTemplate extends AbstractOAuth2ApiBinding implements Runkeeper {

    public RunkeeperTemplate(String accessToken) {
        super(accessToken);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        MappingJackson2HttpMessageConverter jsonMessageConverter = getJsonMessageConverter();

        return Arrays.asList(
                new RunkeeperMessageConverter(User.class, MediaType.valueOf(User.MEDIA_TYPE), jsonMessageConverter),
                new RunkeeperMessageConverter(Profile.class, MediaType.valueOf(Profile.MEDIA_TYPE), jsonMessageConverter),
                new RunkeeperMessageConverter(FitnessActivityFeed.class, MediaType.valueOf(FitnessActivityFeed.MEDIA_TYPE), jsonMessageConverter),
                new RunkeeperMessageConverter(FitnessActivity.class, MediaType.valueOf(FitnessActivity.MEDIA_TYPE), jsonMessageConverter));
    }

    public HealthGraphOperations healthGraph() {
        return new HealthGraphTemplate(getRestTemplate());
    }

}
