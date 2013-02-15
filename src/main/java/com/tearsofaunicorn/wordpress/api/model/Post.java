package com.tearsofaunicorn.wordpress.api.model;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Post implements Serializable {

	private static final long serialVersionUID = -6834915997622886337L;

	private final String title;
	private final String content;
	private Category category;
	private Set<Tag> tags;

	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		this.tags = new TreeSet<Tag>();
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Tag> getTags() {
		return this.tags;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
	}

	public boolean hasTaxonomies() {
		return this.category != null || !this.tags.isEmpty();
	}

	@Override
	public String toString() {
		return this.title;
	}
}
