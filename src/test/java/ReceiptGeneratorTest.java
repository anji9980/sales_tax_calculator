import org.apache.taxcalculatorapp.model.CartItem;
import org.apache.taxcalculatorapp.model.Item;
import org.apache.taxcalculatorapp.model.Receipt;
import org.apache.taxcalculatorapp.service.BasicSalesTax;
import org.apache.taxcalculatorapp.service.ImportDutyTax;
import org.apache.taxcalculatorapp.service.ReceiptGenerator;
import org.apache.taxcalculatorapp.service.TaxCalculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptGeneratorTest {

    @Test
    void testReceiptCalculation() {
        Item item = new Item("music CD", 14.99, false, false);
        CartItem cartItem = new CartItem(item, 1);

        TaxCalculator calculator = new TaxCalculator(List.of(new BasicSalesTax(), new ImportDutyTax()));
        ReceiptGenerator generator = new ReceiptGenerator(calculator);
        Receipt receipt = generator.generateReceipt(List.of(cartItem));

        assertEquals(1, receipt.getItems().size());
        assertEquals(1.50, receipt.getTotalSalesTax());
        assertEquals(16.49, receipt.getTotalAmount());
    }
}
