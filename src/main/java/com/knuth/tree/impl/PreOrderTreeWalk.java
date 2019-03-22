package com.knuth.tree.impl;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.tree.Action;
import com.knuth.tree.Tree;
import com.knuth.tree.TreeWalk;


/**
 * Visits all tree nodes, each exactly one time, and performs an action at each node.
 * <p/>
 * Parent nodes are visited <em>before</em> children ("pre-order").
 * <p>
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
public class PreOrderTreeWalk implements TreeWalk {

    @Override
    public void walk(Tree a, Action q) {
        Stack s = new LinkedStack();

        while (true) {
            if (a != null) {
                q.act(a);
                a = a.left();
                s.push(a.right());
            } else if (!s.isEmpty()) {
                a = (Tree) s.pop();
            } else {
                break;
            }
        }
    }

}
