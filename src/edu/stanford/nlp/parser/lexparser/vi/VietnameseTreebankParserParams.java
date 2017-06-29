package edu.stanford.nlp.parser.lexparser.vi;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.parser.lexparser.AbstractTreebankParserParams;
import edu.stanford.nlp.parser.lexparser.TreeCollinizer;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.trees.international.vietnamese.VietnameseTreebankLanguagePack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanpn on 6/27/17.
 */
public class VietnameseTreebankParserParams extends AbstractTreebankParserParams {
    private HeadFinder headFinder;

    /**
     * Stores the passed-in TreebankLanguagePack and sets up charset encodings.
     */
    public VietnameseTreebankParserParams() {
        super(new VietnameseTreebankLanguagePack());
        inputEncoding = treebankLanguagePack().getEncoding();
        //TODO Add head finder
    }

    @Override
    public TreeReaderFactory treeReaderFactory() {
        // TODO Add tree reader
        return null;
    }

    @Override
    public List<? extends HasWord> defaultTestSentence() {
        List<Word> ret = new ArrayList<>();
        String [] sent = {"Đây", "là", "câu", "kiểm", "tra"};
        for (String str : sent) {
            ret.add(new Word(str));
        }
        return ret;
    }

    @Override
    public MemoryTreebank memoryTreebank() {
        return new MemoryTreebank(treeReaderFactory(), inputEncoding);
    }

    @Override
    public DiskTreebank diskTreebank() {
        return new DiskTreebank(treeReaderFactory(), inputEncoding);
    }

    @Override
    public HeadFinder headFinder() {
        return headFinder;
    }

    @Override
    public HeadFinder typedDependencyHeadFinder() {
        return headFinder;
    }

    @Override
    public TreeTransformer collinizer() {
        return new TreeCollinizer(treebankLanguagePack());
    }

    @Override
    public TreeTransformer collinizerEvalb() {
        return new TreeCollinizer(treebankLanguagePack());
    }

    @Override
    public String[] sisterSplitters() {
        return new String[0];
    }

    @Override
    public Tree transformTree(Tree t, Tree root) {
        return t;
    }

    @Override
    public void display() {

    }


}
