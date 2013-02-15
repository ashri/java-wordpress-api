package com.tearsofaunicorn.wordpress.api.model.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.tearsofaunicorn.wordpress.api.model.Post;
import com.tearsofaunicorn.wordpress.api.model.Tag;

public class PostConverter implements Converter<Post, Map<String, Object>> {

	private final String defaultPostType;
	private final String defaultPostStatus;

	public PostConverter(String defaultPostType, String defaultPostStatus) {
		this.defaultPostType = defaultPostType;
		this.defaultPostStatus = defaultPostStatus;
	}

	public Map<String, Object> convert(Post fromObject) {

		Map<String, Object> post = new HashMap<String, Object>();
		post.put("post_type", this.defaultPostType);
		post.put("post_status", this.defaultPostStatus);
		post.put("post_title", fromObject.getTitle());
		post.put("post_content", fromObject.getContent());

		if (fromObject.hasTaxonomies()) {
			Map<String, String[]> terms = new HashMap<String, String[]>();
			post.put("terms_names", terms);

			if (fromObject.getCategory() != null) {
				terms.put("category", new String[] { fromObject.getCategory().getName() });
			}

			Set<Tag> tags = fromObject.getTags();
			if (!tags.isEmpty()) {
				String[] tagTerms = new String[tags.size()];
				int i = 0;
				for (Tag tag : tags) {
					tagTerms[i] = tag.getName();
					i++;
				}
				terms.put("post_tag", tagTerms);
			}
		}
		return post;
	}
}
