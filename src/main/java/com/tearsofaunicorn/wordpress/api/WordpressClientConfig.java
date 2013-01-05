package com.tearsofaunicorn.wordpress.api;

import java.net.URL;

/**
 * Configuration for accessing a Wordpress blog
 */
public class WordpressClientConfig {

    private static final String DEFAULT_BLOG_ID = "default";

    private String blogId;
    private final String userName;
    private final String password;
    private final URL url;


    public WordpressClientConfig(String userName, String password, URL blogApiUrl) {

        if (userName == null) {
            throw new IllegalArgumentException("userName must not be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("password must not be null");
        }
        if (blogApiUrl == null) {
            throw new IllegalArgumentException("blogApiUrl must not be null");
        }

        this.blogId = DEFAULT_BLOG_ID;

        this.userName = userName;
        this.password = password;
        this.url = blogApiUrl;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public URL getUrl() {
        return url;
    }
}
