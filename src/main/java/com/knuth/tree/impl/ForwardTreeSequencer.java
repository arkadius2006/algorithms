package com.knuth.tree.impl;

import com.knuth.tree.Tree;
import com.knuth.tree.Sequence;
import com.knuth.tree.TreeSequencer;

/**
 * Produces a sequence of all tree nodes in "forward" order:
 * parent nodes appear before children in the sequence.
 */
public class ForwardTreeSequencer implements TreeSequencer {

    @Override
    public Sequence enumerate(Tree root) {
        return new ForwardSequence(root);
    }
}
