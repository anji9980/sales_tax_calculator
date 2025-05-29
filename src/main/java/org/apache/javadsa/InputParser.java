package org.apache.javadsa;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final List<String> exemptKeywords = List.of("book", "chocolate", "pill");

    public static List<Product> parse(String[] lines) {
        List<Product> products = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(" at ");
            String left = parts[0];
            double price = Double.parseDouble(parts[1]);

            String[] tokens = left.split(" ", 2);
            int quantity = Integer.parseInt(tokens[0]);
            String name = tokens[1];

            boolean isImported = name.contains("imported");
            boolean isExempt = exemptKeywords.stream().anyMatch(name::contains);

            // adding all product items with info related to product. isExempt, quantity etc..
            products.add(new Product(name, price, isImported, isExempt, quantity));
        }
        return products;
    }
}
