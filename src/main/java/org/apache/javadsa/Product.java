package org.apache.javadsa;

public class Product {
    private final String name;
    private final double price;
    private final boolean isImported;
    private final boolean isExempt;
    private final int quantity;

    // constructor to intialize the values.
    public Product(String name, double price, boolean isImported, boolean isExempt, int quantity) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
        this.quantity = quantity;
    }

    // getters for each individual fields in the product line.
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public int getQuantity() {
        return quantity;
    }
}
