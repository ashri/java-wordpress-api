package com.tearsofaunicorn.wordpress.api;

public class WordpressClientException extends RuntimeException {

    public WordpressClientException(String message, Exception cause) {
        super(message, cause);
    }
}
