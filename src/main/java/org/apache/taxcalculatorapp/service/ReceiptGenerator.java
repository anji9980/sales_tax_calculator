package org.apache.taxcalculatorapp.service;

import org.apache.taxcalculatorapp.model.CartItem;
import org.apache.taxcalculatorapp.model.Item;
import org.apache.taxcalculatorapp.model.Receipt;
import org.apache.taxcalculatorapp.model.ReceiptItem;

import java.util.List;

public class ReceiptGenerator {

    private final TaxCalculator taxCalculator;

    public ReceiptGenerator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public Receipt generateReceipt(List<CartItem> cartItems) {
        Receipt receipt = new Receipt();

        for (CartItem cartItem : cartItems) {
            Item item = cartItem.getItem();
            int quantity = cartItem.getQuantity();

            double itemTax = taxCalculator.calculateTotalTax(item) * quantity;
            double totalPriceWithTax = taxCalculator.calculateTotalPrice(cartItem);

            ReceiptItem receiptItem = new ReceiptItem(quantity, item.getName(), totalPriceWithTax);
            receipt.addItem(receiptItem);
            receipt.addSalesTax(itemTax);
            receipt.addTotalAmount(totalPriceWithTax);
        }

        return receipt;
    }
}
