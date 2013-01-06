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
import java.util.Map;
import java.util.Set;

public class WordpressClient {

    private final XmlRpcBridge bridge;
    private final String defaultNewPostType;
    private final String defaultNewPostStatus;

    public WordpressClient(XmlRpcBridge bridge, String defaultNewPostType, String defaultNewPostStatus) {
        this.bridge = bridge;
        this.defaultNewPostType = defaultNewPostType;
        this.defaultNewPostStatus = defaultNewPostStatus;
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
