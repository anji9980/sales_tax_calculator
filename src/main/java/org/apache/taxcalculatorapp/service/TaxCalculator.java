package org.apache.taxcalculatorapp.service;

import org.apache.taxcalculatorapp.model.CartItem;
import org.apache.taxcalculatorapp.model.Item;

import java.util.List;

public class TaxCalculator {

    private final List<TaxRule> taxRules;

    public TaxCalculator(List<TaxRule> taxRules) {
        this.taxRules = taxRules;
    }

    public double calculateTotalTax(Item item){
        double tax = 0.0;
        for(TaxRule rule: taxRules){
            tax += rule.calulateTax(item);
        }
        return roundUpToNearestFiveCents(tax);
    }

    public double calculateTotalPrice(CartItem cartItem) {
        double unitPriceWithTax = cartItem.getItem().getPrice() + calculateTotalTax(cartItem.getItem());
        return round(unitPriceWithTax * cartItem.getQuantity());
    }

    public static double roundUpToNearestFiveCents(double value) {
        return Math.ceil(value * 20.0) / 20.0;
    }

    public static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
