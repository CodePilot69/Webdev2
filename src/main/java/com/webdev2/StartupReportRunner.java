package com.webdev2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * CommandLineRunner bean — executes automatically after the Spring context
 * is fully loaded.
 *
 * Demonstrates that all beans (ProductRepository, ShopProperties,
 * ProductService) are correctly wired by Spring's IoC container.
 */
@Component
public class StartupReportRunner implements CommandLineRunner {

    private static final double PRICE_THRESHOLD = 5000.0;

    private final ProductService productService;

    // Constructor injection — Spring provides ProductService
    public StartupReportRunner(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) {
        ShopProperties shop = productService.getShopProperties();
        List<Product>  products = productService.getProductsAbovePrice(PRICE_THRESHOLD);

        System.out.println();
        System.out.println("================================");
        System.out.println("       PRODUCT REPORT");
        System.out.println("================================");
        System.out.println("Shop: "     + shop.getName());
        System.out.println("Currency: " + shop.getCurrency());
        System.out.println();
        System.out.println("Products above " + shop.getCurrency()
                + " " + (int) PRICE_THRESHOLD + ":");
        System.out.println();

        for (Product p : products) {
            System.out.println("  " + p.getName()
                    + " - " + shop.getCurrency()
                    + " " + (int) p.getPrice());
        }

        System.out.println("================================");
        System.out.println();
    }
}
