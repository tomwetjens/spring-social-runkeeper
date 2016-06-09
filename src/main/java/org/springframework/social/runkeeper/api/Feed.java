package org.springframework.social.runkeeper.api;

import java.util.Iterator;

public interface Feed<T> extends Iterator<T> {

    int getSize();

}
