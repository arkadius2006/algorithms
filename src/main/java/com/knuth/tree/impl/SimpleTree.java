package com.knuth.tree.impl;

import com.knuth.tree.Tree;

class SimpleTree implements Tree {
    private final Object payload;
    private final Tree left;
    private final Tree right;

    public SimpleTree(Object payload, Tree left, Tree right) {
        this.payload = payload;
        this.left = left;
        this.right = right;
    }

    @Override
    public Object payload() {
        return payload;
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
        return String.valueOf(payload);
    }
}
