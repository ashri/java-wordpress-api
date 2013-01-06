package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.Category;
import com.tearsofaunicorn.wordpress.api.model.Post;
import com.tearsofaunicorn.wordpress.api.model.Tag;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Map;

public class PostConverterTest {

    @Test
    public void testConvert() throws Exception {

        Post fromObject = new Post("Post title", "Post content");
        fromObject.setCategory(new Category("1", "Category name", "Category description"));
        fromObject.addTag(new Tag("2", "Tag name", "Tag description"));

        Map<String, Object> post = new PostConverter("post", "published").convert(fromObject);
        Assert.assertEquals("post", post.get("post_type"));
        Assert.assertEquals("published", post.get("post_status"));
        Assert.assertEquals("Post title", post.get("post_title"));
        Assert.assertEquals("Post content", post.get("post_content"));

        @SuppressWarnings("unchecked")
        Map<String, String[]> terms = (Map<String, String[]>) post.get("terms_names");
        Assert.assertNotNull(terms);

        Assert.assertNotNull(terms.get("category"));
        String[] categories = terms.get("category");
        Assert.assertEquals("Category name", categories[0]);

        Assert.assertNotNull(terms.get("post_tag"));
        String[] tags = terms.get("post_tag");
        Assert.assertEquals("Tag name", tags[0]);
    }
}
