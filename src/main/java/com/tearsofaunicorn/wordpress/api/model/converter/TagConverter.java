package com.tearsofaunicorn.wordpress.api.model.converter;

import java.util.Map;

import com.tearsofaunicorn.wordpress.api.model.Tag;

public class TagConverter implements Converter<Map<String, Object>, Tag> {

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
