package edu.stanford.nlp.trees.international.vietnamese;

import edu.stanford.nlp.international.spanish.process.SpanishTokenizer;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.AbstractTreebankLanguagePack;
import edu.stanford.nlp.trees.HeadFinder;

/**
 * Created by lanpn on 6/27/17.
 */
public class VietnameseTreebankLanguagePack extends AbstractTreebankLanguagePack {
    private static final String [] PUNCT_WORDS = {"''", "'", "``", "`", ".", "?", "!", ",", ":", "-", "--", "...", ";"};
    private static final String [] PUNCT_TAGS = {"''", "'", "``", "`", ".", "?", "!", ",", ":", "-", "--", "...", ";",
             "[", "]", "\"", "{", "}"};
    private static final String [] SF_PUNCT_WORDS = {".", "?", "!", "..."};
    private static final String[] START_SYMBOLS = {"ROOT"};
    private static final String TREEBANK_EXT = "conllu";

    @Override
    public TokenizerFactory<? extends HasWord> getTokenizerFactory() {
        //TODO Change Tokenizer
        return SpanishTokenizer.factory(new CoreLabelTokenFactory(),
                "invertible,ptb3Escaping=true,splitAll=true");
    }

    @Override
    public String[] punctuationTags() {
        return PUNCT_TAGS;
    }

    @Override
    public String[] punctuationWords() {
        return PUNCT_WORDS;
    }

    @Override
    public String[] sentenceFinalPunctuationTags() {
        return SF_PUNCT_WORDS;
    }

    @Override
    public String[] startSymbols() {
        return START_SYMBOLS;
    }

    @Override
    public String[] sentenceFinalPunctuationWords() {
        return SF_PUNCT_WORDS;
    }

    @Override
    public String treebankFileExtension() {
        return TREEBANK_EXT;
    }

    @Override
    public HeadFinder headFinder() {
        //TODO Add HeadFinder
        return null;
    }

    @Override
    public HeadFinder typedDependencyHeadFinder() {
        //TODO Add HeadFinder
        return null;
    }
}
