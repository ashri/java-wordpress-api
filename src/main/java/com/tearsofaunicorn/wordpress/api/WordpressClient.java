package com.tearsofaunicorn.wordpress.api;

import com.tearsofaunicorn.wordpress.api.model.Category;
import com.tearsofaunicorn.wordpress.api.model.PostType;
import com.tearsofaunicorn.wordpress.api.model.Tag;

import java.util.Set;

public class WordpressClient {

    public boolean ping() {
        return false;
    }

    public Set<PostType> getPostTypes() {
        return null;
    }

    public Set<Category> getCategories() {
        return null;
    }

    public Set<Tag> getTags() {
        return null;
    }

    public String newPost() {
        return null;
    }
}
