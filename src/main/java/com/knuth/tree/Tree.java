package com.knuth.tree;

/**
 * Binary tree.
 * <p/>
 * Binary tree is a finite set of nodes which is either empty,
 * or consists of a root and two disjointed binary trees: left and right sub-trees.
 */
public interface Tree {

    String root();

    Tree left();

    Tree right();
}
