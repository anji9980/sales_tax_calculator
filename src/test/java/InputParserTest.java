import org.apache.taxcalculatorapp.model.CartItem;
import org.apache.taxcalculatorapp.parser.InputParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private final InputParser parser = new InputParser();

    @Test
    void testValidParsing() {
        CartItem item = parser.parseLise("1 imported bottle of perfume at 27.99");
        assertEquals("imported bottle of perfume", item.getItem().getName());
        assertEquals(27.99, item.getItem().getPrice());
        assertTrue(item.getItem().isImported());
        assertFalse(item.getItem().isExempt());
    }

    @Test
    void testInvalidFormatThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> parser.parseLise("this is wrong input"));
    }
}
