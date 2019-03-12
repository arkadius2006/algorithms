package com.knuth.tree;

public class ForwardSequencer implements Sequencer {

    @Override
    public Sequence enumerate(Node root) {
        return new ForwardSequence(root);
    }
}
