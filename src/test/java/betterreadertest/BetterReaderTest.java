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
            assertTrue("hasNext-true", reader.hasNext());
            assertTrue("getLine", reader.getLine().startsWith("Lorem ipsum"));
            assertEquals("getLineNo", 1, reader.getLineNo());
            reader.hasNext();
            reader.hasNext();
            reader.hasNext();
            reader.hasNext();
            reader.hasNext();
            reader.hasNext();
            assertFalse("hasNext-false", reader.hasNext());
            reader.close();
        } catch (FileNotFoundException ex) {
            fail();
        } catch (IOException ex) {
            fail();
        }
    }
}
