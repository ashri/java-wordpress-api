package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.Tag;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Map;

public class TagConverterTest extends ConverterTest<Map<String, Object>> {

    @Test
    public void testConvert() throws Exception {
        Map<String, Object> xmlrpcResponse = loadObject("./src/test/resources/data/tag-object.stream");

        Tag tag = new TagConverter().convert(xmlrpcResponse);
        Assert.assertNotNull(tag);
        Assert.assertNotNull(tag.getId());
        Assert.assertEquals("failure", tag.getName());
        Assert.assertNotNull(tag.getDescription());
        Assert.assertFalse(tag.getDescription().isEmpty());
    }

}
