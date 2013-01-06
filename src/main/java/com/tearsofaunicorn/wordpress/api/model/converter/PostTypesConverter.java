package com.tearsofaunicorn.wordpress.api.model.converter;

import com.tearsofaunicorn.wordpress.api.model.PostType;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PostTypesConverter implements Converter<Map<String, Object>, Set<PostType>> {

    @Override
    public Set<PostType> convert(Map<String, Object> fromObject) {

        Set<PostType> postTypes = new TreeSet<PostType>();

        for (Object pt : fromObject.values()) {
            @SuppressWarnings("unchecked")
            Map<String, Object> rawPostType = (Map<String, Object>) pt;
            PostType postType = new PostTypeConverter().convert(rawPostType);
            postTypes.add(postType);
        }

        return postTypes;
    }
}
