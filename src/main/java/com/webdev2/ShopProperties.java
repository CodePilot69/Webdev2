package com.webdev2;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Binds properties prefixed with "shop" from application.properties.
 *
 * shop.name     → name
 * shop.currency → currency
 */
@ConfigurationProperties(prefix = "shop")
public class ShopProperties {

    private String name;
    private String currency;

    // ── Getters & Setters required by Spring's binding mechanism ─────────────

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
