package com.knuth.tree.impl;

import com.knuth.tree.Node;

public class NodeBuilder {
    private Object payload;
    private Node left;
    private Node right;

    public Node build() {
        return new SimpleNode(payload, left, right);
    }

    public void payload(Object o) {
        this.payload = o;
    }

    public void left(Node n) {
        this.left = n;
    }

    public void right(Node n) {
        this.right = n;
    }
}
