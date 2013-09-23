package com.undeadscythes.betterreader;

import java.io.*;
import java.util.logging.*;

/**
 * Just one little class to make the business of reading from files a little
 * easier.
 *
 * @author UndeadScythes
 */
public class BetterReader extends BufferedReader {
    private static final Logger LOGGER = Logger.getLogger(BetterReader.class.getName());

    private String line;
    private int lineNo;

    /**
     * Wrap a standard {@link Reader}.
     */
    public BetterReader(final Reader reader) {
        super(reader);
        lineNo = 0;
    }

    /**
     * Wrap an {@link InputStream}.
     */
    public BetterReader(final InputStream input) {
        this(new InputStreamReader(input));
    }

    /**
     * Wrap an {@link InputStream} that has a given encoding.
     */
    public BetterReader(final InputStream input, final String encoding) throws UnsupportedEncodingException {
        this(new InputStreamReader(input, encoding));
    }

    /**
     * Wrap a {@link File}.
     */
    public BetterReader(final File file) throws FileNotFoundException {
        this(new FileReader(file));
    }

    /**
     * Wrap a {@link File file} that has a given encoding.
     */
    public BetterReader(final File file, final String encoding) throws FileNotFoundException, UnsupportedEncodingException {
        this(new FileInputStream(file), encoding);
    }

    /**
     * This method increments the line counter and reads the next line of the
     * input source. The line read can be retrieved using
     * {@link BetterReader#getLine}, calling this method twice will ignore the
     * first line read.
     *
     * @return False if there was no line to be read
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
     * Get the last line that was read with {@link #hasNext}.
     */
    public String getLine() {
        return line;
    }

    /**
     * Get the current line number. This is the number of the line that was last
     * read with {@link #hasNext}.
     */
    public int getLineNo() {
        return lineNo;
    }
}
