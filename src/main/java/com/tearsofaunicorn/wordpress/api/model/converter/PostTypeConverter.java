package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.PostType;
import java.util.Map;

public class PostTypeConverter implements Converter<Map<String, Object>, PostType> {

    @Override
    public PostType convert(Map<String, Object> fromObject) {

        if (fromObject == null) {
            throw new IllegalArgumentException("fromObject must not be null");
        }

        String name = (String) fromObject.get("name");
        String label = (String) fromObject.get("label");
        return new PostType(name, label);
    }
}
