package org.apache.taxcalculatorapp.parser;

import org.apache.taxcalculatorapp.model.CartItem;
import org.apache.taxcalculatorapp.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final Pattern INPUT_PATTERN = Pattern.compile("^(\\d+) (.+) at (\\d+\\.\\d{2})$");

    public CartItem parseLise(String line){
        Matcher mathcer = INPUT_PATTERN.matcher(line);

        // checking if the input format is correct
        if(!mathcer.matches()){
            throw new IllegalArgumentException("Invalid Input format, please check input!: " + line);
        }

        int quantity = Integer.parseInt(mathcer.group(1));
        String name = mathcer.group(2).trim();
        double price = Double.parseDouble(mathcer.group(3));

        boolean isImported = name.toLowerCase().contains("imported");
        boolean isExempt = ExemptionChecker.isExempt(name);

        Item item = new Item(name, price, isImported, isExempt);
        return new CartItem(item, quantity);
    }

    // Optional: if we want to parse multiple lines at a time
    // currently i haven't designed the main method to work this way
    public List<CartItem> parseLines(List<String> lines) {
        List<CartItem> cartItems = new ArrayList<>();
        for (String line : lines) {
            cartItems.add(parseLise(line));
        }
        return cartItems;
    }
}
