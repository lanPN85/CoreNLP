package edu.stanford.nlp.process;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.util.PropertiesUtils;
import edu.stanford.nlp.util.StringUtils;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by lanpn on 6/27/17.
 */
public class TabTokenizer<T extends HasWord> extends AbstractTokenizer<T> {
    private final boolean eolIsSignificant;
    private TabLexer lexer;

    /**
     * A factory which vends TabTokenizers.
     *
     * @author Christopher Manning
     */
    public static class TabTokenizerFactory<T extends HasWord> implements TokenizerFactory<T> {

        private boolean tokenizeNLs;
        private LexedTokenFactory<T> factory;

        /**
         * Constructs a new TokenizerFactory that returns Word objects and
         * treats carriage returns as normal whitespace.
         * THIS METHOD IS INVOKED BY REFLECTION BY SOME OF THE JAVANLP
         * CODE TO LOAD A TOKENIZER FACTORY.  IT SHOULD BE PRESENT IN A
         * TokenizerFactory.
         *
         * @return A TokenizerFactory that returns Word objects
         */
        public static TokenizerFactory<Word> newTokenizerFactory() {
            return new TabTokenizer.TabTokenizerFactory<>(new WordTokenFactory(),
                    false);
        }

        public TabTokenizerFactory(LexedTokenFactory<T> factory) {
            this(factory, false);
        }

        public TabTokenizerFactory(LexedTokenFactory<T> factory,
                                   String options) {
            this.factory = factory;
            Properties prop = StringUtils.stringToProperties(options);
            this.tokenizeNLs = PropertiesUtils.getBool(prop, "tokenizeNLs", false);
        }

        public TabTokenizerFactory(LexedTokenFactory<T> factory,
                                   boolean tokenizeNLs) {
            this.factory = factory;
            this.tokenizeNLs = tokenizeNLs;
        }

        public Iterator<T> getIterator(Reader r) {
            return getTokenizer(r);
        }

        public Tokenizer<T> getTokenizer(Reader r) {
            return new TabTokenizer<>(factory, r, tokenizeNLs);
        }

        public Tokenizer<T> getTokenizer(Reader r, String extraOptions) {
            Properties prop = StringUtils.stringToProperties(extraOptions);
            boolean tokenizeNewlines =
                    PropertiesUtils.getBool(prop, "tokenizeNLs", this.tokenizeNLs);

            return new TabTokenizer<>(factory, r, tokenizeNewlines);
        }


        public void setOptions(String options) {
            Properties prop = StringUtils.stringToProperties(options);
            tokenizeNLs = PropertiesUtils.getBool(prop, "tokenizeNLs", tokenizeNLs);
        }
    } // end class TabTokenizerFactory

    public static TabTokenizer.TabTokenizerFactory<CoreLabel> newCoreLabelTokenizerFactory(String options) {
        return new TabTokenizer.TabTokenizerFactory<>(new CoreLabelTokenFactory(), options);
    }

    public static TabTokenizer.TabTokenizerFactory<CoreLabel> newCoreLabelTokenizerFactory() {
        return new TabTokenizer.TabTokenizerFactory<>(new CoreLabelTokenFactory());
    }

    /**
     * Internally fetches the next token.
     *
     * @return the next token in the token stream, or null if none exists.
     */
    @SuppressWarnings("unchecked")
    @Override
    protected T getNext() {
        T token = null;
        if (lexer == null) {
            return null;
        }
        try {
            token = (T) lexer.next();
            while (token != null && token.word().equals(TabLexer.NEWLINE)) {
                if (eolIsSignificant) {
                    return token;
                } else {
                    token = (T) lexer.next();
                }
            }
        } catch (IOException e) {
            // do nothing, return null
        }
        return token;
    }

    /**
     * Constructs a new TabTokenizer
     *
     * @param r                The Reader that is its source.
     * @param eolIsSignificant Whether eol tokens should be returned.
     */
    public TabTokenizer(LexedTokenFactory factory,
                               Reader r, boolean eolIsSignificant) {
        this.eolIsSignificant = eolIsSignificant;
        // The conditional below is perhaps currently needed in LexicalizedParser, since
        // it passes in a null arg while doing type-checking for sentence escaping
        // but StreamTokenizer barfs on that.  But maybe shouldn't be here.
        if (r != null) {
            lexer = new TabLexer(r, factory);
        }
    }

    public static TabTokenizer<CoreLabel> newCoreLabelTabTokenizer(Reader r) {
        return new TabTokenizer<>(new CoreLabelTokenFactory(), r, false);
    }

    public static TabTokenizer<CoreLabel> newCoreLabelTabTokenizer(Reader r, boolean tokenizeNLs) {
        return new TabTokenizer<>(new CoreLabelTokenFactory(), r, tokenizeNLs);
    }

    public static TabTokenizer<Word>
    newWordTabTokenizer(Reader r) {
        return newWordTabTokenizer(r, false);
    }

    public static TabTokenizer<Word>
    newWordTabTokenizer(Reader r, boolean eolIsSignificant) {
        return new TabTokenizer<>(new WordTokenFactory(), r,
                eolIsSignificant);
    }

    public static TokenizerFactory<Word> factory() {
        return new TabTokenizer.TabTokenizerFactory<>(new WordTokenFactory(),
                false);
    }

    public static TokenizerFactory<Word> factory(boolean eolIsSignificant) {
        return new TabTokenizer.TabTokenizerFactory<>(new WordTokenFactory(),
                eolIsSignificant);
    }

    /**
     * Reads a file from the argument and prints its tokens one per line.
     * This is mainly as a testing aid, but it can also be quite useful
     * standalone to turn a corpus into a one token per line file of tokens.
     * <p/>
     * Usage: <code>java edu.stanford.nlp.process.TabTokenizer filename
     * </code>
     *
     * @param args Command line arguments
     * @throws IOException If can't open files, etc.
     */
    public static void main(String[] args) throws IOException {

        boolean eolIsSignificant = (args.length > 0 && args[0].equals("-cr"));
        Reader reader = ((args.length > 0 &&
                !args[args.length - 1].equals("-cr")) ?
                new InputStreamReader(new FileInputStream
                        (args[args.length - 1]), "UTF-8") :
                new InputStreamReader(System.in, "UTF-8"));
        TabTokenizer<Word> tokenizer =
                new TabTokenizer<>(new WordTokenFactory(), reader,
                        eolIsSignificant);
        PrintWriter pw =
                new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        pw.println("Reading from " + args[args.length - 1]);
        while (tokenizer.hasNext()) {
            Word w = tokenizer.next();
            if (w.value().equals(TabLexer.NEWLINE)) {
                pw.println("***CR***");
            } else {
                pw.println(w);
            }
        }
    }
}
