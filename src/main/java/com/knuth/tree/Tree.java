package com.knuth.tree;

/**
 * Binary tree node.
 */
public interface Tree {

    Object payload();

    /**
     * Could be null. Means this node has no left child.
     */
    Tree left();

    /**
     * Could be null. Means this node has no right child.
     */
    Tree right();
}
