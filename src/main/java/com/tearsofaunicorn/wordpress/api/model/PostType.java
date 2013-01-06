package com.tearsofaunicorn.wordpress.api.model;

import java.io.Serializable;

public class PostType implements Serializable, Comparable<PostType> {

    private final String name;
    private final String label;

    public PostType(String name, String label) {
        this.name = name;
        this.label = label;
    }

    public String getName() {
        return this.name;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return this.label;
    }

    @Override
    public int compareTo(PostType p) {
        return this.name.compareTo(p.getName());
    }
}
