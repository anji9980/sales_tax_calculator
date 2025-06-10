package org.apache.taxcalculatorapp.model;

public class ReceiptItem {
    private final int quantity;
    private final String name;
    private final double totalPrice;

    public ReceiptItem(int quantity, String name, double totalPrice) {
        this.quantity = quantity;
        this.name = name;
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
