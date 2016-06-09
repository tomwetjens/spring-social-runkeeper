package org.springframework.social.runkeeper.api.internal;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

class RunkeeperMessageConverter<T> implements HttpMessageConverter<T> {

    private final Class<T> aClass;
    private final MediaType mediaType;
    private final HttpMessageConverter<T> delegate;

    @SuppressWarnings("unchecked")
    public RunkeeperMessageConverter(Class<T> aClass, MediaType mediaType, HttpMessageConverter delegate) {
        this.aClass = aClass;
        this.mediaType = mediaType;
        this.delegate = (HttpMessageConverter<T>) delegate;
    }

    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return aClass.equals(this.aClass) && this.mediaType.isCompatibleWith(mediaType) && delegate.canRead(aClass, mediaType);
    }

    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        return aClass.equals(this.aClass) && this.mediaType.isCompatibleWith(mediaType) && delegate.canWrite(aClass, mediaType);
    }

    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(mediaType);
    }

    public T read(Class<? extends T> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return delegate.read(aClass, httpInputMessage);
    }

    public void write(T t, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        delegate.write(t, mediaType, httpOutputMessage);
    }
}
