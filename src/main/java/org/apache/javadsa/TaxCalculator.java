package org.apache.javadsa;

public class TaxCalculator {
    public static double calculateTax(Product product) {
        double taxRate = 0.0;
        if (!product.isExempt()) {
            taxRate += 0.10;
        }
        if (product.isImported()) {
            taxRate += 0.05;
        }

        double rawTax = product.getPrice() * taxRate;
        return roundUpToNearestPoint05(rawTax);
    }

    private static double roundUpToNearestPoint05(double amount) {
        return Math.ceil(amount * 20.0) / 20.0;
    }
}
