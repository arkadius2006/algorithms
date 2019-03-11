package com.knuth.tree;

/**
 * Binary tree node.
 */
public interface Node {

    Object payload();

    /**
     * Can be null. Means this node has no left child.
     */
    Node leftChild();

    /**
     * Can be null. Means this node has no right child.
     */
    Node rightChild();
}
