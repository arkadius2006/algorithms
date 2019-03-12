package com.knuth.tree;

import java.util.function.Consumer;

public interface Traversal {
    
    void traverse(Node root, Consumer<Object> op);
}
