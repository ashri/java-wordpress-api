package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.Category;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CategoriesConverter implements Converter<Object[], Set<Category>> {

    @Override
    public Set<Category> convert(Object[] fromObject) {

        Set<Category> categories = new TreeSet<Category>();

        for (Object pt : fromObject) {
            @SuppressWarnings("unchecked")
            Map<String, Object> rawCategory = (Map<String, Object>) pt;
            Category postType = new CategoryConverter().convert(rawCategory);
            categories.add(postType);
        }

        return categories;
    }
}
