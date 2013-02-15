package com.tearsofaunicorn.wordpress.api.model;

import java.io.Serializable;

public class Category implements Serializable, Comparable<Category> {

	private static final long serialVersionUID = 1131828629261444384L;

	private final String id;
	private final String name;
	private final String description;

	public Category(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Category(String name) {
		this(null, name, null);
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public int compareTo(Category o) {
		return this.name.compareTo(o.getName());
	}
}
