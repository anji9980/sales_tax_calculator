package org.apache.taxcalculatorapp;

import org.apache.taxcalculatorapp.model.CartItem;
import org.apache.taxcalculatorapp.model.Receipt;
import org.apache.taxcalculatorapp.parser.InputParser;
import org.apache.taxcalculatorapp.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
    Please note that we can make the main method as flexible as we can, right now it will ask for the total
    number of inputs, then total items in each group of input, then it will read the items1, items2... till
    the total items of that group completes, then it will ask for the total inputs of input2(i.e group of items
    input2) and so on.. till all the inputs completes. Once finished it will print all the receipts one by one.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputParser parser = new InputParser();

        // Setup tax rules
        List<TaxRule> taxRules = List.of(new BasicSalesTax(), new ImportDutyTax());
        TaxCalculator taxCalculator = new TaxCalculator(taxRules);
        ReceiptGenerator generator = new ReceiptGenerator(taxCalculator);
        ReceiptPrinter printer = new ReceiptPrinter();

        // To collect the receipts and print at the end
        List<Receipt> receipts = new ArrayList<>();

        // Ask user how many baskets
        System.out.print("Enter number of input groups (e.g. 3): ");
        int numberOfGroups = Integer.parseInt(scanner.nextLine());

        for (int group = 1; group <= numberOfGroups; group++) {
            System.out.println("\nInput " + group + ":");
            System.out.print("Enter number of items in Input " + group + ": ");
            int itemCount = Integer.parseInt(scanner.nextLine());

            List<CartItem> cartItems = new ArrayList<>();
            for (int i = 0; i < itemCount; i++) {
                System.out.print("Enter item " + (i + 1) + ": ");
                String line = scanner.nextLine();
                try {
                    cartItems.add(parser.parseLise(line));
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠️  Error parsing line: " + e.getMessage());
                    i--; // Retry this item
                }
            }

            // Generate reciepts
            Receipt receipt = generator.generateReceipt(cartItems);
            receipts.add(receipt);
        }
        scanner.close();

        for(int i=0; i<receipts.size(); i++){
            System.out.println("\nOutput "+ (i+1) + ":");
            printer.printReceipt(receipts.get(i));
        }
    }
}
