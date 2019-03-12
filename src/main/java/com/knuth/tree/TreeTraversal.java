package com.knuth.tree;


/**
 * Visits all tree nodes in some order. Each node is visited exactly one time.
 * Performs operation at each node.
 * <p/>
 * Essentially, an algorithm that implements this interface
 * produces some linear ordering of tree nodes.
 */
public interface TreeTraversal {

    void traverse(Node root, Action action);
}
