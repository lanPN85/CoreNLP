#!/usr/bin/env bash

#java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.parser.nndep.DependencyParser\
# -model _vi/nndep.vi.model.txt.gz\
# -testFile _vi/vi-ud-dev2.conllu

java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
 edu.stanford.nlp.parser.nndep.DependencyParser\
 -model _vi/nndep.vi.bench.txt.gz\
 -testFile _vi/vi-ud-dev2.conllu
