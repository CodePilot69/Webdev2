package com.webdev2;

/**
 * Simple category class — provides the nested property access
 * required by Task 2: product.category.name
 */
public class Category {

    private final String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
