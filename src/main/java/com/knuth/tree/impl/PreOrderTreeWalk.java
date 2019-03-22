package com.knuth.tree.impl;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.tree.TreeWalkListener;
import com.knuth.tree.Tree;
import com.knuth.tree.TreeWalk;


/**
 * Visits all tree nodes, each exactly one time, and performs an action at each node.
 * <p/>
 * Parent nodes are visited <em>before</em> children ("pre-order").
 * <p>
 * This is explicit version of the following recursive algorithm:
 * <pre>
 * void R(Tree t, TreeWalkListener a) {
 *     if (t != null) {
 *         a.onNode(t);
 *         R(t.left());
 *         R(t.right());
 *     }
 * }
 * </pre>
 */
public class PreOrderTreeWalk implements TreeWalk {

    @Override
    public void walk(Tree a, TreeWalkListener q) {
        Stack s = new LinkedStack();

        while (true) {
            if (a != null) {
                q.onNode(a);
                Tree b = a.left();
                Tree c = a.right();
                if (c != null) {
                    s.push(c);
                }
                a = b;
            } else if (!s.isEmpty()) {
                a = (Tree) s.pop();
            } else {
                break;
            }
        }
    }

}
