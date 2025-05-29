package org.apache.javadsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String[] SAMPLE_INPUT_1 = {
            "1 book at 12.49",
            "1 music CD at 14.99",
            "1 chocolate bar at 0.85"
    };

    private static final String[] SAMPLE_INPUT_2 = {
            "1 imported box of chocolates at 10.00",
            "1 imported bottle of perfume at 47.50"
    };

    private static final String[] SAMPLE_INPUT_3 = {
            "1 imported bottle of perfume at 27.99",
            "1 bottle of perfume at 18.99",
            "1 packet of headache pills at 9.75",
            "1 box of imported chocolates at 11.25"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose input mode:");
        System.out.println("1. Sample Input 1");
        System.out.println("2. Sample Input 2");
        System.out.println("3. Sample Input 3");
        System.out.println("4. Enter items manually");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String[] inputLines;

        // switch cases to handle the iputs and the type users want to avail.
        // 1-3 inputs will execute the hardcoded input and 4 will ask for user to enter.
        switch (choice) {
            case 1 -> inputLines = SAMPLE_INPUT_1;
            case 2 -> inputLines = SAMPLE_INPUT_2;
            case 3 -> inputLines = SAMPLE_INPUT_3;
            case 4 -> inputLines = readDynamicInput(scanner);
            default -> {
                System.out.println("Invalid choice. Exiting.");
                return;
            }
        }

        List<Product> products = InputParser.parse(inputLines);

        Receipt receipt = new Receipt();
        for (Product product : products) {
            receipt.addItem(new ReceiptItem(product));
        }

        System.out.println("\n--- Receipt ---");
        ReceiptPrinter.printReceipt(receipt);
    }

    private static String[] readDynamicInput(Scanner scanner) {
        System.out.println("Enter items (type 'done' when finished):");
        List<String> inputs = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("done")) {
                break;
            }
            if (!line.isEmpty()) {
                inputs.add(line);
            }
        }
        return inputs.toArray(new String[0]);
    }
}
