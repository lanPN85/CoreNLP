#!/usr/bin/env bash

java -cp ../lib/stanford-corenlp-3.8.0.jar edu.stanford.nlp.parser.nndep.DependencyParser\
 -trainFile en-ud-train.conllu -devFile en-ud-dev.conllu -embedFile glove.6B.50d.txt -embeddingSize 50\
 -model nndep.en.model.txt.gz -maxIter 250 -trainingThreads 2 -wordCutOff 10
