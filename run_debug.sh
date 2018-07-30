#!/usr/bin/env bash
#java -Xms200m -Xmx200m -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.parser.nndep.DependencyParser\
# -model nndep.vi.model.txt.gz -tagger.model ./_vi/vtb38.tagger\
# -textFile ./_vi/vi-ud-train.txt -outFile ./_vi/vi-ud-train.out

#java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.process.DocumentPreprocessor _vi/vnnews2.txt -suppressEscaping > _vi/vnnews_spl.txt

#java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.tagger.maxent.MaxentTagger -prop ./_vi/vietnamese.properties\
# -model _vi/vtb38.tagger

java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
 edu.stanford.nlp.pipeline.StanfordCoreNLP -props ./_vi/vietnamese.properties\
 -file _vi/vnnews_spl.txt
