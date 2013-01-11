package com.tearsofaunicorn.wordpress.api.model;

import java.io.Serializable;

public class Category implements Serializable, Comparable<Category> {

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
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Category o) {
        return this.name.compareTo(o.getName());
    }
}
