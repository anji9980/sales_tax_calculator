package org.apache.taxcalculatorapp.model;

public class Item {
    private final String name;
    private final double price;
    private final boolean isImported;
    private final boolean isExempt;

    // constructor
    public Item(String name, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
    }

    // getters
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
}
