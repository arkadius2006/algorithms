package com.knuth.tree.impl;

import com.knuth.tree.Node;

public class NodeBuilder {
    private final Object payload;
    private Node left;
    private Node right;

    public NodeBuilder(Object payload) {
        this.payload = payload;
    }
    public Node build() {
        return new SimpleNode(payload, left, right);
    }

    public void left(Node n) {
        this.left = n;
    }

    public void right(Node n) {
        this.right = n;
    }
}
