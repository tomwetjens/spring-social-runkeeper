/*
 * Copyright (C) 2016, Alphabet International GmbH
 */

package com.wetjens.springframework.social.runkeeper.api;

import java.util.Iterator;

public interface Feed<T> extends Iterator<T> {

    int getSize();
}
