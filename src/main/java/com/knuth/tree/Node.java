package com.knuth.tree;

/**
 * Binary tree node.
 */
public interface Node {

    Object payload();

    /**
     * Could be null. Means this node has no left child.
     */
    Node leftChild();

    /**
     * Could be null. Means this node has no right child.
     */
    Node rightChild();
}
