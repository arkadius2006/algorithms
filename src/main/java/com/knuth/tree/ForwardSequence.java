package com.knuth.tree;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;

public class ForwardSequence implements Sequence {
    private final Stack nodes;

    public ForwardSequence(Node root) {
        nodes = new LinkedStack();
        nodes.push(root);
    }

    public Object next() {
        Node x = popUntilNonNullNodeFound();

        if (x != null) {
            Object payload = x.payload();
            nodes.push(x.leftChild());
            nodes.push(x.rightChild());

            return payload;
        } else {
            return null;
        }
    }

    private Node popUntilNonNullNodeFound() {
        // pop until discover non-null node or get to the bottom of stack
        Node x = null;
        while (x == null && !nodes.isEmpty()) {
            x = (Node) nodes.pop();
        }

        return x;
    }
}
