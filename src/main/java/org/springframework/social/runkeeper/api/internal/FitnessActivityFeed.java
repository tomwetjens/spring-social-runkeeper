package org.springframework.social.runkeeper.api.internal;

import org.springframework.social.runkeeper.api.Feed;
import org.springframework.social.runkeeper.api.FitnessActivity;
import org.springframework.social.runkeeper.api.User;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class FitnessActivityFeed implements Feed<FitnessActivity> {

    public static final String MEDIA_TYPE = "application/vnd.com.runkeeper.FitnessActivityFeed+json";

    private static class FitnessActivityFeedResponse {

        private List<FitnessActivity> items;
        private int size;
        private String previous;
        private String next;

        public List<FitnessActivity> getItems() {
            return items;
        }

        public int getSize() {
            return size;
        }

        public String getPrevious() {
            return previous;
        }

        public String getNext() {
            return next;
        }
    }

    private final RestTemplate restTemplate;
    private final String baseUrl;

    private FitnessActivityFeedResponse page;
    private Iterator<FitnessActivity> iterator;

    FitnessActivityFeed(RestTemplate restTemplate, String baseUrl, User user) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;

        retrievePage(baseUrl + user.getFitnessActivities());
    }

    private void retrievePage(String url) {
        this.page = restTemplate.getForObject(url, FitnessActivityFeedResponse.class);
        this.iterator = page.getItems().iterator();
    }

    public int getSize() {
        return page.getSize();
    }

    @Override
    public boolean hasNext() {
        if (!iterator.hasNext() && page.getNext() != null) {
            retrievePage(baseUrl + page.getNext());
        }
        return iterator.hasNext();
    }

    @Override
    public FitnessActivity next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iterator.next();
    }
}
