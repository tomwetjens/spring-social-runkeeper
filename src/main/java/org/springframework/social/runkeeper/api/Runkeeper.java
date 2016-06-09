package org.springframework.social.runkeeper.api;

import org.springframework.social.ApiBinding;

public interface Runkeeper extends ApiBinding {

    HealthGraphOperations healthGraph();

}
