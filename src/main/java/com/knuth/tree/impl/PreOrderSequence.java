package com.knuth.tree.impl;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.tree.Item;
import com.knuth.tree.Tree;
import com.knuth.tree.Sequence;

class PreOrderSequence implements Sequence {
    private final Stack nodes;

    public PreOrderSequence(Tree root) {
        nodes = new LinkedStack();
        nodes.push(root);
    }

    public Item next() {
        Tree x = popUntilNonNullNodeFound();

        if (x != null) {
            Object payload = x.payload();
            nodes.push(x.left());
            nodes.push(x.right());

            return Item.of(payload);
        } else {
            return Item.empty();
        }
    }

    private Tree popUntilNonNullNodeFound() {
        // pop until discover non-null node or get to the bottom of stack
        Tree x = null;
        while (x == null && !nodes.isEmpty()) {
            x = (Tree) nodes.pop();
        }

        return x;
    }
}
