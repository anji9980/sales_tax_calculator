import org.apache.taxcalculatorapp.model.Item;
import org.apache.taxcalculatorapp.service.BasicSalesTax;
import org.apache.taxcalculatorapp.service.ImportDutyTax;
import org.apache.taxcalculatorapp.service.TaxCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    private TaxCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TaxCalculator(List.of(new BasicSalesTax(), new ImportDutyTax()));
    }

    @Test
    void testBasicTax() {
        Item item = new Item("music CD", 14.99, false, false);
        double tax = calculator.calculateTotalTax(item);
        assertEquals(1.50, tax);
    }

    @Test
    void testImportedExemptItem() {
        Item item = new Item("imported chocolates", 10.00, true, true);
        double tax = calculator.calculateTotalTax(item);
        assertEquals(0.50, tax); // only import duty
    }
}
