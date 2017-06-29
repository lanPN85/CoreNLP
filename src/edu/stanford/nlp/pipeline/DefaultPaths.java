package edu.stanford.nlp.pipeline;

import edu.stanford.nlp.parser.nndep.DependencyParser;

import java.lang.reflect.Field;

/**
 * Default model paths for StanfordCoreNLP
 * All these paths point to files distributed with the model jar file (stanford-corenlp-models-*.jar)
 */
public class DefaultPaths {

  public static final String DEFAULT_POS_MODEL = "models/pos-tagger/english-left3words/english-left3words-distsim.tagger";

  public static final String DEFAULT_PARSER_MODEL = "models/lexparser/englishPCFG.ser.gz";

  @SuppressWarnings("UnusedDeclaration") // Used in a script
  public static final String DEFAULT_DEPENDENCY_PARSER_MODEL = DependencyParser.DEFAULT_MODEL;

  public static final String DEFAULT_NER_THREECLASS_MODEL = "models/ner/english.all.3class.distsim.crf.ser.gz";
  public static final String DEFAULT_NER_CONLL_MODEL = "models/ner/english.conll.4class.distsim.crf.ser.gz";
  public static final String DEFAULT_NER_MUC_MODEL = "models/ner/english.muc.7class.distsim.crf.ser.gz";
  public static final String DEFAULT_NER_GAZETTE_MAPPING = "models/ner/regexner.patterns";

  public static final String DEFAULT_REGEXNER_RULES = "models/regexner/type_map_clean";
  public static final String DEFAULT_GENDER_FIRST_NAMES = "models/gender/first_name_map_small";

  public static final String DEFAULT_TRUECASE_MODEL = "models/truecase/truecasing.fast.caseless.qn.ser.gz";
  public static final String DEFAULT_TRUECASE_DISAMBIGUATION_LIST = "models/truecase/MixDisambiguation.list";

  public static final String DEFAULT_DCOREF_ANIMATE = "models/dcoref/animate.unigrams.txt";
  public static final String DEFAULT_DCOREF_DEMONYM = "models/dcoref/demonyms.txt";
  public static final String DEFAULT_DCOREF_INANIMATE = "models/dcoref/inanimate.unigrams.txt";
  public static final String DEFAULT_DCOREF_STATES = "models/dcoref/state-abbreviations.txt";

  public static final String DEFAULT_DCOREF_COUNTRIES = "models/dcoref/countries";
  public static final String DEFAULT_DCOREF_STATES_AND_PROVINCES = "models/dcoref/statesandprovinces";
  public static final String DEFAULT_DCOREF_GENDER_NUMBER = "models/dcoref/gender.map.ser.gz";
  
  public static final String DEFAULT_DCOREF_SINGLETON_MODEL = "models/dcoref/singleton.predictor.ser";
  public static final String DEFAULT_DCOREF_DICT1 = "models/dcoref/coref.dict1.tsv";
  public static final String DEFAULT_DCOREF_DICT2 = "models/dcoref/coref.dict2.tsv";
  public static final String DEFAULT_DCOREF_DICT3 = "models/dcoref/coref.dict3.tsv";
  public static final String DEFAULT_DCOREF_DICT4 = "models/dcoref/coref.dict4.tsv";
  public static final String DEFAULT_DCOREF_NE_SIGNATURES = "models/dcoref/ne.signatures.txt";

  public static final String DEFAULT_NFL_ENTITY_MODEL = "models/machinereading/nfl/nfl_entity_model.ser";
  public static final String DEFAULT_NFL_RELATION_MODEL = "models/machinereading/nfl/nfl_relation_model.ser";
  public static final String DEFAULT_NFL_GAZETTEER = "models/machinereading/nfl/NFLgazetteer.txt";
  
  public static final String DEFAULT_SUP_RELATION_EX_RELATION_MODEL = "models/supervised_relation_extractor/roth_relation_model_pipelineNER.ser";

  public static final String DEFAULT_NATURALLI_AFFINITIES = "models/naturalli/affinities";  // If you change this key, also change bin/mkopenie.sh
  public static final String DEFAULT_OPENIE_CLAUSE_SEARCHER = "models/naturalli/clauseSearcherModel.ser.gz";  // If you change this key, also change bin/mkopenie.sh

  public static final String DEFAULT_KBP_CLASSIFIER = "models/kbp/tac-re-lr.ser.gz";
  public static final String DEFAULT_KBP_REGEXNER_CASED = "models/kbp/regexner_cased.tab";
  public static final String DEFAULT_KBP_REGEXNER_CASELESS = "models/kbp/regexner_caseless.tab";
  public static final String DEFAULT_KBP_SEMGREX_DIR = "models/kbp/semgrex";
  public static final String DEFAULT_KBP_TOKENSREGEX_DIR = "models/kbp/tokensregex";

  public static final String DEFAULT_KBP_TOKENSREGEX_NER_SETTINGS =
          "ignorecase=true,validpospattern=^(NN|JJ).*,edu/stanford/nlp/models/kbp/regexner_caseless.tab;" +
                  "models/kbp/regexner_cased.tab";

  public static final String DEFAULT_WIKIDICT_TSV = "models/kbp/wikidict.tab.gz";


  private DefaultPaths() {
  }

  /**
   * Go through all of the paths via reflection, and print them out in a TSV format.
   * This is useful for command line scripts.
   *
   * @param args Ignored.
   */
  public static void main(String[] args) throws IllegalAccessException {
    for (Field field : DefaultPaths.class.getFields()) {
      System.out.println(field.getName() + "\t" + field.get(null));
    }
  }
  
}
