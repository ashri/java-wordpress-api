package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.Category;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Set;

public class CategoriesConverterTest extends ConverterTest<Object[]> {

    @Test
    public void testConvert() throws Exception {
        Object[] xmlrpcResponse = loadObject("./src/test/resources/data/categories-object.stream");

        Set<Category> categories = new CategoriesConverter().convert(xmlrpcResponse);
        Assert.assertNotNull(categories);
        Assert.assertFalse(categories.isEmpty());
    }
}
