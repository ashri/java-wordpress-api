package com.tearsofaunicorn.wordpress.api.model.converter;

import java.util.Map;

import com.tearsofaunicorn.wordpress.api.model.PostType;

public class PostTypeConverter implements Converter<Map<String, Object>, PostType> {

	public PostType convert(Map<String, Object> fromObject) {

		if (fromObject == null) {
			throw new IllegalArgumentException("fromObject must not be null");
		}

		String name = (String) fromObject.get("name");
		String label = (String) fromObject.get("label");
		return new PostType(name, label);
	}
}
