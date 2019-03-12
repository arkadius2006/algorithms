package com.knuth.tree;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;

import java.util.Iterator;
import java.util.NoSuchElementException;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public Object next() {
        // pop until discover non-null node or get to the bottom of stack
        Node x = null;
        while (x == null && !roots.isEmpty()) {
            x = (Node) roots.pop();
        }

        if (x != null) {
            Object value = x.payload();
            roots.push(x.leftChild());
            roots.push(x.rightChild());

            return value;
        } else {
            return new NoSuchElementException();
        }
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
