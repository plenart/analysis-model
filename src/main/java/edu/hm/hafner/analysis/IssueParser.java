package edu.hm.hafner.analysis;

import java.io.File;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.function.Function;

/**
 * Parses a file and returns the issues reported in this file.
 *
 * @param <T>
 *         subtype of created issues
 *
 * @author Ullrich Hafner
 */
public abstract class IssueParser<T extends Issue> implements Serializable {
    /**
     * Parses the specified file for issues.
     *
     * @param file
     *         the file to parse
     * @param charset
     *         the encoding to use when reading files
     * @param preProcessor
     *         pre processes each input line before handing it to the actual parser
     *
     * @return the issues
     * @throws ParsingException
     *         Signals that during parsing a non recoverable error has been occurred
     * @throws ParsingCanceledException
     *         Signals that the parsing has been aborted by the user
     */
    public abstract Issues<T> parse(File file, Charset charset, Function<String, String> preProcessor)
            throws ParsingException, ParsingCanceledException;

    /**
     * Parses the specified file for issues.
     *
     * @param file
     *         the file to parse
     * @param charset
     *         the encoding to use when reading files
     *
     * @return the issues
     * @throws ParsingException
     *         Signals that during parsing a non recoverable error has been occurred
     * @throws ParsingCanceledException
     *         Signals that the parsing has been aborted by the user
     */
    public Issues<T> parse(final File file, final Charset charset)
            throws ParsingException, ParsingCanceledException {
        return parse(file, charset, Function.identity());
    }
}
