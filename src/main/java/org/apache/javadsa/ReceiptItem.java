package org.apache.javadsa;

public class ReceiptItem {

    // class which will help us in maintianing the recipt info related each product.

    private final Product product;
    private final double salesTax;
    private final double totalPrice;

    public ReceiptItem(Product product) {
        this.product = product;
        this.salesTax = TaxCalculator.calculateTax(product) * product.getQuantity();
        this.totalPrice = (product.getPrice() + TaxCalculator.calculateTax(product)) * product.getQuantity();
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getPrintedLine() {
        return product.getQuantity() + " " + product.getName() + ": " + String.format("%.2f", totalPrice);
    }
}
