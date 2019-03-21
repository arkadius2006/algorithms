package com.knuth.tree.impl;

import com.knuth.tree.Tree;

public class NodeBuilder {
    private final Object payload;
    private Tree left;
    private Tree right;

    public NodeBuilder(Object payload) {
        this.payload = payload;
    }
    public Tree build() {
        return new SimpleTree(payload, left, right);
    }

    public void left(Tree n) {
        this.left = n;
    }

    public void right(Tree n) {
        this.right = n;
    }
}
