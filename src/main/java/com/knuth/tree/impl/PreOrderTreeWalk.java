package com.knuth.tree.impl;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.tree.Tree;
import com.knuth.tree.TreeWalk;

import java.util.function.Consumer;


/**
 * Visits all tree nodes, each exactly one time, and performs an action at each node.
 * <p/>
 * Parent nodes are visited <em>before</em> children ("pre-order").
 * <p>
 * This is explicit version of the following recursive algorithm:
 * <pre>
 * void R(Tree a, Consumer q) {
 *     if (t != null) {
 *         q.accept(t);
 *         R(t.left());
 *         R(t.right());
 *     }
 * }
 * </pre>
 */
public class PreOrderTreeWalk implements TreeWalk {

    @Override
    public void walk(Tree a, Consumer<Tree> q) {
        Stack stack = new LinkedStack();
        stack.push(a);

        while (!stack.isEmpty()) {
            a = (Tree) stack.pop();

            if (a != null) {
                // A is tree to be traversed
                // expand in stack: A -> a B C
                // where B is left sub-tree, C is right sub-tree
                // and small "a" is the root node itself to be visited
                q.accept(a);
                stack.push(a.right());
                stack.push(a.left()); // will be popped as "a" on the next iteration
            }
        }
    }

}
