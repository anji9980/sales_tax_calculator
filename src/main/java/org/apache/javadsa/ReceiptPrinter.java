package org.apache.javadsa;

public class ReceiptPrinter {

    // A helper class to print the info
    // Defined it as static so that we can directly access with the help of class name.

    public static void printReceipt(Receipt receipt) {
        for (ReceiptItem item : receipt.getItems()) {
            System.out.println(item.getPrintedLine());
        }
        System.out.printf("Sales Taxes: %.2f\n", receipt.getTotalSalesTax());
        System.out.printf("Total: %.2f\n", receipt.getTotalAmount());
    }
}