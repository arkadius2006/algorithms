package com.knuth.tree.impl;

import com.knuth.tree.Node;

class SimpleNode implements Node {
    private final Object payload;
    private final Node left;
    private final Node right;

    public SimpleNode(Object payload, Node left, Node right) {
        this.payload = payload;
        this.left = left;
        this.right = right;
    }

    @Override
    public Object payload() {
        return payload;
    }

    @Override
    public Node left() {
        return left;
    }

    @Override
    public Node right() {
        return right;
    }
}
