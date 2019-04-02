package com.knuth.tree.impl;

import com.knuth.tree.Tree;

class SimpleTree implements Tree {
    private final String root;
    private final Tree left;
    private final Tree right;

    public SimpleTree(String root, Tree left, Tree right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    @Override
    public String root() {
        return root;
    }

    @Override
    public Tree left() {
        return left;
    }

    @Override
    public Tree right() {
        return right;
    }

    @Override
    public String toString() {
        return String.valueOf(root);
    }
}
