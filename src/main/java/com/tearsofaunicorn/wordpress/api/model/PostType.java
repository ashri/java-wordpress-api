package com.tearsofaunicorn.wordpress.api.model;

public class PostType {

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
}
