package com.tearsofaunicorn.wordpress.api;

import com.tearsofaunicorn.wordpress.api.model.Category;
import com.tearsofaunicorn.wordpress.api.model.Post;
import com.tearsofaunicorn.wordpress.api.model.PostType;
import com.tearsofaunicorn.wordpress.api.model.Tag;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.Set;

@Ignore
public class WordpressClientTest {

    private WordpressClient client;

    @Before
    public void setUp() throws Exception {
        this.client = new WordpressClient();
    }

    @Test
    public void testGetPostTypes() throws Exception {
        Set<PostType> postTypes = client.getPostTypes();
        Assert.assertNotNull(postTypes);
        Assert.assertFalse(postTypes.isEmpty());
    }

    @Test
    public void testGetCategories() throws Exception {
        Set<Category> categories = client.getCategories();
        Assert.assertNotNull(categories);
        Assert.assertFalse(categories.isEmpty());
        Category o = categories.iterator().next();
        Assert.assertEquals("Jenkins", o.getName());
    }

    @Test
    public void testGetTags() throws Exception {
        Set<Tag> tags = client.getTags();
        Assert.assertNotNull(tags);
        Assert.assertFalse(tags.isEmpty());
        Tag o = tags.iterator().next();
        Assert.assertEquals("failure", o.getName());
    }

    @Test
    @Ignore
    public void testNewPost() throws Exception {
        Post post = new Post("WordpressClient unit test post", "Posting from a unit test for the WordpressClient class");
        String postId = client.newPost(post);
        Assert.assertNotNull(postId);
        Assert.assertFalse(postId.isEmpty());
    }
}
