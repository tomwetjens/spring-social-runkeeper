/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.api;

import org.springframework.social.ApiBinding;

public interface Runkeeper extends ApiBinding {

    HealthGraphOperations healthGraph();
}
