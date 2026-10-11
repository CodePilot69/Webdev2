package com.webdev2;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * In-memory product repository — no database required.
 */
@Repository
public class ProductRepository {

    private final AtomicInteger idCounter = new AtomicInteger(4);

    private final List<Product> products = new ArrayList<>(List.of(
        new Product(1, "Laptop",   45000.0, new Category("Electronics")),
        new Product(2, "Mouse",      800.0, new Category("Accessories")),
        new Product(3, "Keyboard",  1500.0, new Category("Accessories"))
    ));

    public List<Product> findAll() {
        return List.copyOf(products);
    }

    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public Product save(Product product) {
        product.setId(idCounter.getAndIncrement());
        // Assign a default category if none provided
        if (product.getCategory() == null) {
            product.setCategory(new Category("General"));
        }
        products.add(product);
        return product;
    }
}
