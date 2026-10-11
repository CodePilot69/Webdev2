package com.webdev2;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * ProductController — handles all views under /products.
 *
 * Task 1 — GET  /products          → products.html  (list view)
 * Task 2 — GET  /products/{id}     → product-detail.html
 * Task 3 — navbar fragment included in both templates
 * Task 4 — GET  /products/new      → product-form.html (empty form)
 *           POST /products         → saves + redirects (PRG)
 * Task 5 — POST /products with @Valid + BindingResult → redisplays form on error
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ── Task 1 — Product list ────────────────────────────────────────────────

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";                  // → templates/products.html
    }

    // ── Task 2 — Product detail ──────────────────────────────────────────────

    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Optional<Product> result = productRepository.findById(id);
        if (result.isEmpty()) {
            return "redirect:/products";    // graceful fallback
        }
        model.addAttribute("product", result.get());
        return "product-detail";            // → templates/product-detail.html
    }

    // ── Task 4 — Show empty create form ─────────────────────────────────────

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";              // → templates/product-form.html
    }

    // ── Task 4 & 5 — Handle form submission ─────────────────────────────────

    /**
     * POST /products
     *
     * @Valid triggers Bean Validation on the bound Product.
     * BindingResult must immediately follow the model attribute —
     * if there are errors, redisplay the form (Task 5).
     * On success, save and redirect (PRG pattern — Task 4).
     */
    @PostMapping
    public String createProduct(@Valid @ModelAttribute Product product,
                                BindingResult result) {

        // Task 5 — redisplay form when binding/validation errors exist
        if (result.hasErrors()) {
            return "product-form";
        }

        productRepository.save(product);
        return "redirect:/products";        // Task 4 — PRG redirect
    }
}
