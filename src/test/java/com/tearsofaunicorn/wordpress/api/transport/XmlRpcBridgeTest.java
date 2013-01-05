package com.tearsofaunicorn.wordpress.api.transport;


import com.tearsofaunicorn.wordpress.api.WordpressClientConfig;
import junit.framework.Assert;
import org.apache.xmlrpc.XmlRpcException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class XmlRpcBridgeTest {

    private XmlRpcBridge bridge;

    @Before
    public void setup() throws MalformedURLException {
        String username = System.getProperty("wordpress.username");
        String password = System.getProperty("wordpress.password");
        URL url = new URL(System.getProperty("wordpress.url"));

        WordpressClientConfig config = new WordpressClientConfig(username, password, url);

        this.bridge = new XmlRpcBridge(config);
    }

    @Test
    @Ignore
    public void testNewPost() throws XmlRpcException {
        Map<String, Object> post = new HashMap<String, Object>();
        post.put("post_type", "post");
        post.put("post_status", "draft");
        post.put("post_title", "Test title from new API client");
        post.put("post_content", "Test post created during unit testing.");

        Map<String, String[]> terms = new HashMap<String, String[]>();
        terms.put("category", new String[] {"Jenkins"});
        terms.put("post_tag", new String[] {"success", "wordpress-client-api", "unit-test"});
        post.put("terms_names", terms);

        String ret = this.bridge.newPost(post);
        Assert.assertNotNull(ret);
        System.out.println(ret);
    }

    @Test
    public void testGetPostTypes() throws XmlRpcException {

        Map<String, Object> ret = this.bridge.getPostTypes();
        Assert.assertNotNull(ret);
    }

    @Test
    public void testGetCategories() throws XmlRpcException {

        Object[] ret = this.bridge.getCategories();
        Assert.assertNotNull(ret);
    }

    @Test
    public void testGetTags() throws XmlRpcException {

        Object[] ret = this.bridge.getTags();
        Assert.assertNotNull(ret);
    }
}
