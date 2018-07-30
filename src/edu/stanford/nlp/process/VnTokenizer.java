package edu.stanford.nlp.process;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import vn.hus.nlp.tokenizer.VietTokenizer;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lanpn on 7/3/17.
 */
public class VnTokenizer<T extends HasWord> extends AbstractTokenizer<T> {
    private LexedTokenFactory<T> factory;
    private VietTokenizer tokenizer;
    private String buffer;
    protected ArrayList<String> tokens;
    private Reader reader;

    private static final int BUFFER_COUNT = 50;

    public VnTokenizer(LexedTokenFactory<T> factory, Reader reader){
        this.factory = factory;
        this.reader = reader;
        this.tokenizer = new VietTokenizer();
        this.buffer = new String();
        this.tokens = new ArrayList<>();

        fillBuffer();
    }

    private void fillBuffer(){
        StringBuffer stringBuffer = new StringBuffer();
        int start = 0;
        char [] chars = new char[BUFFER_COUNT];
        while (true){
            try {
                int numRead = reader.read(chars, start, BUFFER_COUNT);
                if (numRead == 0) break;
                start += numRead;
                stringBuffer.append(chars);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        buffer = stringBuffer.toString();
    }

    public static VnTokenizer.VnTokenizerFactory<CoreLabel> newCoreLabelTokenizerFactory(String options) {
        return new VnTokenizer.VnTokenizerFactory<>(new CoreLabelTokenFactory());
    }

    public static VnTokenizer.VnTokenizerFactory<CoreLabel> newCoreLabelTokenizerFactory() {
        return new VnTokenizer.VnTokenizerFactory<>(new CoreLabelTokenFactory());
    }

    @Override
    public List<T> tokenize() {
        return super.tokenize();
    }

    @Override
    protected T getNext() {
        return null;
    }

    public static class VnTokenizerFactory <T extends HasWord> implements TokenizerFactory<T> {
        private LexedTokenFactory<T> factory;

        public static TokenizerFactory<Word> newTokenizerFactory() {
            return new VnTokenizer.VnTokenizerFactory<>(new WordTokenFactory());
        }

        public VnTokenizerFactory(LexedTokenFactory<T> factory){
            this.factory = factory;
        }

        @Override
        public Iterator<T> getIterator(Reader r) {
            return getTokenizer(r);
        }

        @Override
        public Tokenizer<T> getTokenizer(Reader r) {
            return new VnTokenizer<>(factory, r);
        }

        @Override
        public Tokenizer<T> getTokenizer(Reader r, String extraOptions) {
            return null;
        }

        @Override
        public void setOptions(String options) {

        }
    }
}
