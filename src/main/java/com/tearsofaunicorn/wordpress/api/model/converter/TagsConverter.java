package com.tearsofaunicorn.wordpress.api.model.converter;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.tearsofaunicorn.wordpress.api.model.Tag;

public class TagsConverter implements Converter<Object[], Set<Tag>> {

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
