#!/usr/bin/env bash
#java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.tagger.maxent.MaxentTagger -model _vi/vtb38_bench.tagger\
# -testFile format=TSV,wordColumn=0,tagColumn=1,./_vi/bench_pos.tsv

#java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.tagger.maxent.MaxentTagger -model _vi/vtb38_vlsp.tagger\
# -testFile format=TSV,wordColumn=0,tagColumn=1,./_vi/merged_pos.tsv

#java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.tagger.maxent.MaxentTagger -model _vi/vtb38_ud.tagger\
# -testFile format=TSV,wordColumn=1,tagColumn=4,./_vi/vi-ud-merged.conllu

java -Xms1g -Xmx1g -cp classes/artifacts/stanford-corenlp-vi.jar\
 edu.stanford.nlp.tagger.maxent.MaxentTagger -model _vi/vtb38_bench.tagger\
 -testFile format=TSV,wordColumn=1,tagColumn=4,./_vi/vi-ud-train2.conllu
