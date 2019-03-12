package com.knuth.tree;

import java.util.function.Consumer;

/**
 * Visits all tree nodes in some order. Each node is visited exactly one time.
 * Performs operation at each node.
 * <p/>
 * Essentially, an algorithm that implements this interface
 * produces some linear ordering of tree nodes.
 */
public interface Traversal {

    void traverse(Node root, Consumer<Object> op);
}
