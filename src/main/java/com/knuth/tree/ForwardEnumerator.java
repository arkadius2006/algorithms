package com.knuth.tree;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Produces a sequence of all tree nodes in "forward" order:
 * parent nodes appear before children in the sequence.
 */
public class ForwardEnumerator implements Iterator<Object> {
    private final Stack roots;

    public ForwardEnumerator(Node root) {
        roots = new LinkedStack();
        roots.push(root);
    }

    @Override
    public boolean hasNext() {
        //
        return false;

    }

    @Override
    public Object next() {
        if (roots.isEmpty()) {
            throw new IllegalStateException();
        }

        Node x = (Node) roots.pop();
        if () {

        }

        Object payload = x.payload();
        roots.push(x.leftChild());
        roots.push(x.rightChild());

        return payload;
    }

    public void traverse(Consumer<Object> sink) {
        while (!roots.isEmpty()) {
            Node x = (Node) roots.pop();

            if (x != null) {
                Object payload = x.payload();
                sink.accept(payload);

                roots.push(x.leftChild());
                roots.push(x.rightChild());
            }
        }
    }
}
