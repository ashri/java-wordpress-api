package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.Tag;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TagsConverter implements Converter<Object[], Set<Tag>> {

    @Override
    public Set<Tag> convert(Object[] fromObject) {

        Set<Tag> tags = new TreeSet<Tag>();

        for (Object pt : fromObject) {
            @SuppressWarnings("unchecked")
            Map<String, Object> rawTag = (Map<String, Object>) pt;
            Tag postType = new TagConverter().convert(rawTag);
            tags.add(postType);
        }

        return tags;
    }
}
