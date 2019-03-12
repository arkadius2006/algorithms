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
public class ForwardEnumerator<T> implements Iterator<T> {
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
    public T next() {
        // pop until discover non-null node or get to the bottom of stack
        Node<T> x = null;
        while (x == null && !roots.isEmpty()) {
            x = (Node<T>) roots.pop();
        }

        if (x != null) {
            T value = x.payload();
            roots.push(x.leftChild());
            roots.push(x.rightChild());

            return value;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void traverse(Consumer<T> sink) {
        while (!roots.isEmpty()) {
            Node<T> x = (Node<T>) roots.pop();

            if (x != null) {
                T payload = x.payload();
                sink.accept(payload);

                roots.push(x.leftChild());
                roots.push(x.rightChild());
            }
        }
    }
}
