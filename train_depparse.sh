#!/usr/bin/env bash
java -Xms4g -Xmx4g -cp classes/artifacts/stanford-corenlp-vi.jar\
 edu.stanford.nlp.parser.nndep.DependencyParser\
 -model _vi/nndep.vi.model.txt.gz -trainFile _vi/vi-ud-merged.conllu\
 -maxIter 500 -embedFile _vi/wiki.vi.vec -embeddingSize 300

#java -Xms4g -Xmx4g -cp classes/artifacts/stanford-corenlp-vi.jar\
# edu.stanford.nlp.parser.nndep.DependencyParser\
# -model _vi/nndep.vi.bench.txt.gz -trainFile _vi/vi-ud-train2.conllu\
# -maxIter 500 -embedFile _vi/wiki.vi.vec -embeddingSize 300

#     * Training options:
#     * adaAlpha                0.01    Global learning rate for AdaGrad training
#     * adaEps                  1e-6    Epsilon value added to the denominator of AdaGrad update expression for numerical stability
#     * batchSize               10000   Size of mini-batch used for training
#     * clearGradientsPerIter   0       Clear AdaGrad gradient histories every n iterations. If zero, no gradient clearing is performed.
#     * dropProb                0.5     Dropout probability. For each training example we randomly choose some amount of units to disable
#                                       in the neural network classifier. This parameter controls the proportion of units "dropped out."
#     * embeddingSize           50      Dimensionality of word embeddings provided
#     * evalPerIter             100     Run full UAS (unlabeled attachment score) evaluation every time we finish this number of iterations.
#                                       (Only valid if a development treebank is provided with <tt>&#8209;devFile</tt>.)
#     * hiddenSize              200     Dimensionality of hidden layer in neural network classifier
#     * initRange               0.01    Bounds of range within which weight matrix elements should be initialized.
#                                       Each element is drawn from a uniform distribution over the range [-initRange, initRange].
#     * maxIter                 20000   Number of training iterations to complete before stopping and saving the final model.
#     * numPreComputed          100000  The parser pre-computes hidden-layer unit activations for particular inputs words at both training
#                                       and testing time in order to speed up feedforward computation in the neural network.
#                                       This parameter determines how many words for which we should compute hidden-layer activations.
#     * regParameter            1e-8    Regularization parameter for training
#     * saveIntermediate        true    If true, continually save the model version which gets the highest UAS value on the dev set.
#                                       (Only valid if a development treebank is provided with devFile)
#     * trainingThreads         1       Number of threads to use during training. Note that depending on training batch size,
#                                       it may be unwise to simply choose the maximum amount of threads for your machine.
#                                       On our 16-core test machines: a batch size of 10,000 runs fastest with around 6 threads;
#                                       a batch size of 100,000 runs best with around 10 threads.
#     * wordCutOff              1       The parser can optionally ignore rare words by simply choosing an arbitrary "unknown"
#                                       feature representation for words that appear with frequency less than n in the corpus.
#                                       This n is controlled by the wordCutOff parameter.
