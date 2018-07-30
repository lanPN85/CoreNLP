#!/usr/bin/env bash
java -Xms2000m -Xmx2000m -cp ../build/classes/main:../lib/edu.stanford.nlp.tagger-2.0.jar\
 edu.stanford.nlp.parser.nndep.DependencyParser\
 -model nndep.vi.model.txt.gz -tagger.model vtb.tagger -tagger.props vtb.tagger.props\
 -textFile vi-ud-train.txt -outFile vi-ud-train.out