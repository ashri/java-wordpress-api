package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.Tag;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Set;

public class TagsConverterTest extends ConverterTest<Object[]> {

    @Test
    public void testConvert() throws Exception {
        Object[] xmlrpcResponse = loadObject("./src/test/resources/data/tags-object.stream");

        Set<Tag> tags = new TagsConverter().convert(xmlrpcResponse);
        Assert.assertNotNull(tags);
        Assert.assertFalse(tags.isEmpty());
    }
}
