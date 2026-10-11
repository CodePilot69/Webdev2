package com.webdev2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer that contains business logic for products.
 *
 * Dependencies are injected through the constructor (Task 3).
 * Spring sees a single constructor and injects both beans automatically —
 * no @Autowired annotation is needed in Spring 4.3+.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ShopProperties    shopProperties;

    // ── Constructor injection — Spring supplies both beans ───────────────────
    public ProductService(ProductRepository productRepository,
                          ShopProperties shopProperties) {
        this.productRepository = productRepository;
        this.shopProperties    = shopProperties;
    }

    /**
     * Returns products whose price is strictly greater than the given threshold.
     *
     * @param priceThreshold minimum price (exclusive)
     * @return filtered list of products
     */
    public List<Product> getProductsAbovePrice(double priceThreshold) {
        return productRepository.findAll().stream()
                .filter(p -> p.getPrice() > priceThreshold)
                .collect(Collectors.toList());
    }

    public ShopProperties getShopProperties() {
        return shopProperties;
    }
}
