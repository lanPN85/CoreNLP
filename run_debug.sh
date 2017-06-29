#!/usr/bin/env bash
#java -Xms200m -Xmx200m -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.parser.nndep.DependencyParser\
# -model nndep.vi.model.txt.gz -tagger.model vtb.tagger\
# -textFile - -outFile -

java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
 edu.stanford.nlp.pipeline.StanfordCoreNLP -props ./_vi/vietnamese.properties
