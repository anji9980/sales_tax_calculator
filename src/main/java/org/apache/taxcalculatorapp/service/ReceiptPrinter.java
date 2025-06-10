package org.apache.taxcalculatorapp.service;

import org.apache.taxcalculatorapp.model.Receipt;
import org.apache.taxcalculatorapp.model.ReceiptItem;


public class ReceiptPrinter {

    public void printReceipt(Receipt receipt) {
        for (ReceiptItem item : receipt.getItems()) {
            System.out.printf("%d %s: %.2f%n", item.getQuantity(), item.getName(), item.getTotalPrice());
        }

        System.out.printf("Sales Taxes: %.2f%n", receipt.getTotalSalesTax());
        System.out.printf("Total: %.2f%n", receipt.getTotalAmount());
    }
}
