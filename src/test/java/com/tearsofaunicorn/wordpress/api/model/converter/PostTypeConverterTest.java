package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.PostType;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Map;

public class PostTypeConverterTest extends ConverterTest<Map<String, Object>> {

    @Test
    public void testConvert() throws Exception {
        Map<String, Object> xmlrpcResponse = loadObject("./src/test/resources/data/postType-object.stream");
        @SuppressWarnings("unchecked")
        Map<String, Object> postResponse = (Map<String, Object>) xmlrpcResponse.get("post");

        PostType postType = new PostTypeConverter().convert(postResponse);
        Assert.assertEquals("post", postType.getName());
        Assert.assertEquals("Posts", postType.getLabel());
    }

}
