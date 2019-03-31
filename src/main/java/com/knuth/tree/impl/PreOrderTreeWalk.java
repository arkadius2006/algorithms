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
    public void walk(Tree x, Consumer<Tree> q) {
        Stack stack = new LinkedStack();
        stack.push(x);

        while (!stack.isEmpty()) {
            x = (Tree) stack.pop();

            if (x != null) {
                q.accept(x);
                stack.push(x.right());
                stack.push(x.left()); // will be popped as "x" on the next iteration
            }
        }
    }

}
