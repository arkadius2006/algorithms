package com.knuth.tree.impl;

import com.knuth.tree.Tree;

public class TreeBuilder {
    private final String root;
    private Tree left;
    private Tree right;

    public TreeBuilder(String root) {
        this.root = root;
    }
    public Tree build() {
        return new SimpleTree(root, left, right);
    }

    public void left(Tree n) {
        this.left = n;
    }

    public void right(Tree n) {
        this.right = n;
    }
}
