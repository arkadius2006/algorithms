package com.knuth.tree;

/**
 * Produces a sequence of all tree nodes in "forward" order:
 * parent nodes appear before children in the sequence.
 */
public class ForwardTreeSequencer implements TreeSequencer {

    @Override
    public Sequence enumerate(Node root) {
        return new ForwardSequence(root);
    }
}
