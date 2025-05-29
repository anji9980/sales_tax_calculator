import org.apache.javadsa.Product;
import org.apache.javadsa.TaxCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class TaxCalculatorTest {
    @Test
    public void testTaxRounding() {
        Product product = new Product("music CD", 14.99, false, false, 1);
        double tax = TaxCalculator.calculateTax(product);
        assertEquals(1.50, tax, 0.001);
    }

    @Test
    public void testImportedExemptProductTax() {
        Product product = new Product("imported box of chocolates", 10.00, true, true, 1);
        double tax = TaxCalculator.calculateTax(product);
        assertEquals(0.50, tax, 0.001);
    }
}