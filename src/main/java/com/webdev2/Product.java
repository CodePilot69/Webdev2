package com.webdev2;

/**
 * Domain class representing a product in the shop.
 * Plain Java object — Spring does not manage this directly.
 */
public class Product {

    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name  = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}
