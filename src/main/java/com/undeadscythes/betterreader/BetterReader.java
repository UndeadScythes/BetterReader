package com.undeadscythes.betterreader;

import java.io.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;

/**
 * Just one little class to make the business of reading from files a little
 * easier.
 *
 * @author UndeadScythes
 */
public class BetterReader extends BufferedReader {
    private static final Logger LOGGER = getLogger(BetterReader.class.getName());

    private String line;
    private int lineNo;

    /**
     * Wrap a standard {@link Reader}.
     *
     * @param reader
     */
    public BetterReader(final Reader reader) {
        super(reader);
        lineNo = 0;
    }

    /**
     * Wrap an {@link InputStream}.
     *
     * @param input
     */
    public BetterReader(final InputStream input) {
        this(new InputStreamReader(input));
    }

    /**
     * Wrap a {@link File}.
     *
     * @param file
     * @throws FileNotFoundException
     */
    public BetterReader(final File file) throws FileNotFoundException {
        this(new FileReader(file));
    }

    /**
     * This method increments the line counter and reads the next line of the
     * input source. The line read can be retrieved using
     * {@link BetterReader#getLine}, calling this method twice will ignore the
     * first line read.
     *
     * @return True if there was another line to be read
     */
    public boolean hasNext() {
        try {
            line = super.readLine();
            lineNo++;
        } catch (IOException ex) {
            LOGGER.severe(ex.getMessage());
            return false;
        }
        return line != null;
    }

    /**
     * @return Returns the last line read
     */
    public String getLine() {
        return line;
    }

    /**
     * @return Current line number
     */
    public int getLineNo() {
        return lineNo;
    }
}
