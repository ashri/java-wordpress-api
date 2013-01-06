package com.tearsofaunicorn.wordpress.api;

import org.apache.xmlrpc.XmlRpcException;

public class WordpressClientException extends RuntimeException {

    public WordpressClientException(String message, XmlRpcException cause) {
        super(message, cause);
    }
}
