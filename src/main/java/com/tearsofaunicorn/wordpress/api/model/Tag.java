package com.tearsofaunicorn.wordpress.api.model;

import java.io.Serializable;

public class Tag implements Serializable, Comparable<Tag> {

	private static final long serialVersionUID = 997246779778927061L;

	private final String id;
	private final String name;
	private final String description;

	public Tag(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Tag(String name) {
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

	public int compareTo(Tag o) {
		return this.name.compareTo(o.getName());
	}
}
