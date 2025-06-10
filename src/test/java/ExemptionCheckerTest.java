import org.apache.taxcalculatorapp.parser.ExemptionChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExemptionCheckerTest {

    @Test
    void testExemptBook() {
        assertTrue(ExemptionChecker.isExempt("book"));
    }

    @Test
    void testExemptChocolate() {
        assertTrue(ExemptionChecker.isExempt("box of chocolates"));
    }

    @Test
    void testExemptPills() {
        assertTrue(ExemptionChecker.isExempt("headache pills"));
    }

    @Test
    void testNonExemptPerfume() {
        assertFalse(ExemptionChecker.isExempt("bottle of perfume"));
    }
}
