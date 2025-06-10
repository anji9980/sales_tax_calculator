import org.apache.taxcalculatorapp.model.Receipt;
import org.apache.taxcalculatorapp.model.ReceiptItem;
import org.apache.taxcalculatorapp.service.ReceiptPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptPrinterTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ReceiptPrinter printer;
    private Receipt receipt;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        printer = new ReceiptPrinter();

        receipt = new Receipt();
        receipt.addItem(new ReceiptItem(1, "book", 12.49));
        receipt.addItem(new ReceiptItem(1, "music CD", 16.49));
        receipt.addSalesTax(1.50);
        receipt.addTotalAmount(12.49 + 16.49);
    }

    @Test
    void testReceiptPrintsCorrectly() {
        printer.printReceipt(receipt);
        String output = outputStream.toString().trim();

        assertTrue(output.contains("1 book: 12.49"));
        assertTrue(output.contains("1 music CD: 16.49"));
        assertTrue(output.contains("Sales Taxes: 1.50"));
        assertTrue(output.contains("Total: 28.98"));
    }

    @Test
    void tearDown() {
        System.setOut(originalOut);
    }
}
