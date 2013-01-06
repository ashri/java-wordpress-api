package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.Category;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Map;

public class CategoryConverterTest extends ConverterTest<Map<String, Object>> {

    @Test
    public void testConvert() throws Exception {
        Map<String, Object> xmlrpcResponse = loadObject("./src/test/resources/data/category-object.stream");

        Category category = new CategoryConverter().convert(xmlrpcResponse);
        Assert.assertNotNull(category);
        Assert.assertNotNull(category.getId());
        Assert.assertEquals("Jenkins", category.getName());
        Assert.assertNotNull(category.getDescription());
        Assert.assertFalse(category.getDescription().isEmpty());
    }

}
