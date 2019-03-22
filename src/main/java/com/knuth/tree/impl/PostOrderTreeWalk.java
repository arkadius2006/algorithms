package com.knuth.tree.impl;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.tree.Tree;
import com.knuth.tree.TreeWalk;

import java.util.function.Consumer;

/**
 * Visits all tree nodes, each exactly one time, and performs an action at each node.
 * <p/>
 * Parent nodes are visited AFTER children ("post-order").
 */

public class PostOrderTreeWalk implements TreeWalk {

    @Override
    public void walk(Tree x, Consumer<Tree> a) {
        // stack contains nodes from root to current node
        // unwinding stack results in moving up to the root
        // top of stack is parent of current node (null is stack is empty)
        Stack stack = new LinkedStack();

        Tree y = null; // previous

        while (x != null || !stack.isEmpty()) {
            // X is tree to be traversed
            // stack contains X parent, grand-parent, etc up to the root
            // Y is prev visited node
            // Case 1: Y is X parent (moved to X from upside)
            // Case 2: Y is X left child (moved to X from downside left)
            // Case 3: Y is X right child (moved to X from downside right)

            // Post-order means moving around node X in the following order
            // X.parent -> X -> X.left -> X -> X.right -> X -> back to X.parent

            if (x == null) {
                // move up
                y = null;
                x = (Tree) stack.pop();
            } else if (isChildOf(x, y)) {
                // memorize x and move left branch
                stack.push(x);
                y = x;
                x = y.left();
            }
            // todo

        }

    }

    private boolean isChildOf(Tree x, Tree y) {
        return y == null || y.left() == x || y.right() == x;
    }
}
