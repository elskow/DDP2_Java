import DDP2.CSUI.utils.IDGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IDGeneratorTests {
    @Test
    public void testIDGenerator() {
        IDGenerator idGenerator = new IDGenerator("Dek Depe", "082212345678");
        assertEquals("DEK-082212345678-75", IDGenerator.generateID());
    }

    @Test
    public void testIDGenerator2() {
        IDGenerator idGenerator = new IDGenerator("Anya", "081234567890");
        assertEquals("ANYA-081234567890-01", IDGenerator.generateID());
    }

    @Test
    public void testIDGenerator3() {
        IDGenerator idGenerator = new IDGenerator("Dek Depe", "081234567890");
        assertEquals("DEK-081234567890-80", IDGenerator.generateID());
    }
}
