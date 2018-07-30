#!/usr/bin/env bash
java -Xms3g -Xmx3g\
 -cp _en/stanford-corenlp-3.8.0.jar:_en/stanford-corenlp-3.8.0-models.jar\
 edu.stanford.nlp.pipeline.StanfordCoreNLPServer
