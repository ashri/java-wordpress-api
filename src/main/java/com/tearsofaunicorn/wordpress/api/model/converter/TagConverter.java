package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.Tag;
import java.util.Map;

public class TagConverter implements Converter<Map<String, Object>, Tag> {

    @Override
    public Tag convert(Map<String, Object> fromObject) {

        if (fromObject == null) {
            throw new IllegalArgumentException("fromObject must not be null");
        }

        String id = (String) fromObject.get("term_id");
        String name = (String) fromObject.get("name");
        String description = (String) fromObject.get("description");
        return new Tag(id, name, description);
    }
}
