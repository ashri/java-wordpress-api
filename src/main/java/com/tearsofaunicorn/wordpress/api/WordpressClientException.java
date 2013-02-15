package com.tearsofaunicorn.wordpress.api;

public class WordpressClientException extends RuntimeException {

	private static final long serialVersionUID = -2592947007204817452L;

	public WordpressClientException(String message, Exception cause) {
		super(message, cause);
	}
}
