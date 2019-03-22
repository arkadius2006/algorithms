package com.knuth.tree;

/**
 * Binary tree. Contains root, left sub-tree and right sub-tree. Either left or
 * right sub-tree could be empty (null reference). Empty tree is valid tree.
 *
 * Tree := empty-tree
 * Tree := (root, Tree, Tree)
 */
public interface Tree {

    Object payload();

    Tree left();

    Tree right();
}
