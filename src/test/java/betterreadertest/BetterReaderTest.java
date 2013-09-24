package betterreadertest;

import com.undeadscythes.betterreader.*;
import java.io.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * @author UndeadScythes
 */
public class BetterReaderTest {
    @Test
    public void readerTest() {
        try {
            final BetterReader reader = new BetterReader(new File("src/test/resources/test.txt"));
            assertTrue(reader.hasNext());
            assertTrue(reader.getLine().startsWith("Lorem ipsum"));
            assertEquals(1, reader.getLineNo());
            reader.hasNext();
            reader.hasNext();
            reader.hasNext();
            reader.hasNext();
            reader.hasNext();
            reader.hasNext();
            assertFalse(reader.hasNext());
            reader.close();
        } catch (FileNotFoundException ex) {
            fail();
        } catch (IOException ex) {
            fail();
        }
    }
}
