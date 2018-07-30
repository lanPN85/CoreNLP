#!/usr/bin/env bash
java -Xms4000m -Xmx4000m -cp ../lib/stanford-corenlp-3.8.0.jar:../lib/stanford-corenlp-models-current.jar\
 edu.stanford.nlp.pipeline.StanfordCoreNLP\
 -props english.properties -parse.outputFormatOptions basicDependencies
