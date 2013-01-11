package com.tearsofaunicorn.wordpress.api;

import com.tearsofaunicorn.wordpress.api.model.Category;
import com.tearsofaunicorn.wordpress.api.model.Post;
import com.tearsofaunicorn.wordpress.api.model.PostType;
import com.tearsofaunicorn.wordpress.api.model.Tag;
import com.tearsofaunicorn.wordpress.api.model.converter.CategoriesConverter;
import com.tearsofaunicorn.wordpress.api.model.converter.PostConverter;
import com.tearsofaunicorn.wordpress.api.model.converter.PostTypesConverter;
import com.tearsofaunicorn.wordpress.api.model.converter.TagsConverter;
import com.tearsofaunicorn.wordpress.api.transport.XmlRpcBridge;
import org.apache.xmlrpc.XmlRpcException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * A client for the Wordpress XML-RPC API.
 * <p/>
 * Can be constructed through provided the details or by using a set of system properties for configuration:
 * -Dwordpress.username=<wordpress username>
 * -Dwordpress.password=<wordpress password>
 * -Dwordpress.url=<URL of Wordpress XML-RPC API endpoint, usually /xml-rpc.php>
 */
public class WordpressClient {

    private static final String DEFAULT_POST_TYPE = "post";
    private static final String DEFAULT_POST_STATUS = "publish";

    private final XmlRpcBridge bridge;
    private final String defaultNewPostType;
    private final String defaultNewPostStatus;

    public WordpressClient(XmlRpcBridge bridge, String defaultNewPostType, String defaultNewPostStatus) {
        this.bridge = bridge;
        this.defaultNewPostType = defaultNewPostType;
        this.defaultNewPostStatus = defaultNewPostStatus;
    }

    public WordpressClient(XmlRpcBridge bridge) {
        this(bridge, WordpressClient.DEFAULT_POST_TYPE, WordpressClient.DEFAULT_POST_STATUS);
    }

    public WordpressClient() {
        String userName = System.getProperty("wordpress.username");
        String password = System.getProperty("wordpress.password");
        String blogApiUrl = System.getProperty("wordpress.url");

        WordpressClientConfig config = null;
        try {
            config = new WordpressClientConfig(userName, password, new URL(blogApiUrl));
        } catch (MalformedURLException e) {
            throw new WordpressClientException("Failed to build Wordpress XML-RPC URL using configured property", e);
        }
        this.bridge = new XmlRpcBridge(config);
        this.defaultNewPostType = DEFAULT_POST_TYPE;
        this.defaultNewPostStatus = DEFAULT_POST_STATUS;
    }

    public Set<PostType> getPostTypes() {

        try {
            Map<String, Object> xmlResponse = bridge.getPostTypes();
            return new PostTypesConverter().convert(xmlResponse);

        } catch (XmlRpcException e) {
            throw new WordpressClientException("Failed to retrieve postTypes", e);
        }
    }

    public Set<Category> getCategories() {
        try {
            Object[] xmlResponse = bridge.getCategories();
            return new CategoriesConverter().convert(xmlResponse);

        } catch (XmlRpcException e) {
            throw new WordpressClientException("Failed to retrieve categories", e);
        }
    }

    public Set<Tag> getTags() {
        try {
            Object[] xmlResponse = bridge.getTags();
            return new TagsConverter().convert(xmlResponse);

        } catch (XmlRpcException e) {
            throw new WordpressClientException("Failed to retrieve tags", e);
        }
    }

    public String newPost(Post post) {

        try {
            PostConverter converter = new PostConverter(this.defaultNewPostType, this.defaultNewPostStatus);
            Map<String, Object> xmlPost = converter.convert(post);
            return bridge.newPost(xmlPost);

        } catch (XmlRpcException e) {
            throw new WordpressClientException("Failed to create new post", e);
        }
    }
}
