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
        Stack s = new LinkedStack();

        while (true) {
            if (a != null) {
                q.accept(a);
                s.push(a.right());
                a = a.left();
            } else if (!s.isEmpty()) {
                a = (Tree) s.pop();
            } else {
                break;
            }
        }
    }

}
