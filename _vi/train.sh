#!/usr/bin/env bash

java -Xms4000m -Xmx4000m -cp ../build/classes/main edu.stanford.nlp.parser.nndep.DependencyParser\
 -trainFile vi-ud-train.conllu -devFile vi-ud-dev.conllu -embedFile wiki.vi.vec -embeddingSize 300\
 -model nndep.vi.model.txt.gz -maxIter 300 -trainingThreads 2 -wordCutOff 5
