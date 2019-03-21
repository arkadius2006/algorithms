package com.knuth.tree.impl;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.tree.Action;
import com.knuth.tree.Tree;
import com.knuth.tree.TreeTraversal;


/**
 * Visits all tree nodes, each exactly one time, and performs an action at each node.
 * <p/>
 * Parent nodes are visited <em>before</em> children ("pre-order").
 *
 * This is explicit version of the following recursive algorithm:
 * <pre>
 * void R(Tree t, Action a) {
 *     if (t != null) {
 *         a.act(t);
 *         R(t.left());
 *         R(t.right());
 *     }
 * }
 * </pre>
 */
public class PreOrderTreeTraversal implements TreeTraversal {

    public void walk(Tree t, Action a) {
        Stack s = new LinkedStack();

        while (t != null || !s.isEmpty()) {
            if (t != null) {
                a.act(t);
                s.push(t);
                t = t.left();
            } else {
                t = (Tree) s.pop();
                t = t.right();
            }
        }
    }

    private void walk() {

    }
}
