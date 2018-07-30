#!/usr/bin/env bash
java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
 edu.stanford.nlp.tagger.maxent.MaxentTagger -prop ./_vi/vtb38_bench.tagger.props\

#java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.tagger.maxent.MaxentTagger -prop ./_vi/vtb38.tagger.props\
