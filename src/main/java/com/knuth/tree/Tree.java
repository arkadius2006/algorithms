package com.knuth.tree;

/**
 * Binary tree node.
 */
public interface Tree {

    Object payload();

    /**
     * Could be null. Means this node has no left sub-tree.
     */
    Tree left();

    /**
     * Could be null. Means this node has no right sub-tree.
     */
    Tree right();
}
