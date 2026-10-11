package com.webdev2;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Domain class representing a product.
 *
 * Validation annotations are used by Task 5 (BindingResult).
 * The no-arg constructor + setters are required for Thymeleaf
 * form binding (th:object / th:field).
 */
public class Product {

    private int      id;

    @NotBlank(message = "Product name is required")
    private String   name;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be zero or greater")
    private Double   price;

    // Nested property — satisfies Task 2: product.category.name
    private Category category;

    // ── No-arg constructor required for Thymeleaf form binding ───────────────
    public Product() {}

    public Product(int id, String name, Double price, Category category) {
        this.id       = id;
        this.name     = name;
        this.price    = price;
        this.category = category;
    }

    // ── Getters & Setters ────────────────────────────────────────────────────

    public int getId()                  { return id; }
    public void setId(int id)           { this.id = id; }

    public String getName()             { return name; }
    public void setName(String name)    { this.name = name; }

    public Double getPrice()            { return price; }
    public void setPrice(Double price)  { this.price = price; }

    public Category getCategory()               { return category; }
    public void setCategory(Category category)  { this.category = category; }
}
