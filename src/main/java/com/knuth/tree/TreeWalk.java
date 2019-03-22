package com.knuth.tree;


import java.util.function.Consumer;

/**
 * Iterates over tree nodes. Each tree node is visited exactly one time.
 * Performs an action at each node.
 * <p/>
 * Essentially, an algorithm that implements this interface
 * produces some linear ordering of tree nodes.
 */
public interface TreeWalk {

    void walk(Tree a, Consumer<Tree> l);
}
