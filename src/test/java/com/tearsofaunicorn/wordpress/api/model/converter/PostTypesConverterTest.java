package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.PostType;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Map;
import java.util.Set;

public class PostTypesConverterTest extends ConverterTest<Map<String, Object>> {

    @Test
    public void testConvert() throws Exception {
        Map<String, Object> xmlrpcResponse = loadObject("./src/test/resources/data/postType-object.stream");

        Set<PostType> postTypes = new PostTypesConverter().convert(xmlrpcResponse);
        Assert.assertNotNull(postTypes);
        Assert.assertFalse(postTypes.isEmpty());
    }
}
