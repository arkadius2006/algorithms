package com.knuth.tree.impl;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.tree.Action;
import com.knuth.tree.Node;
import com.knuth.tree.TreeTraversal;

import java.util.function.Consumer;


/**
 * Visits all tree nodes, each exactly one time, and performs an action at each node.
 * <p/>
 * Parent nodes are visited BEFORE children ("preorder").
 */
public class ForwardTreeTraversal implements TreeTraversal {

    public void traverse(Node root, Action action) {
        Stack stack = new LinkedStack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node x = (Node) stack.pop();
            acceptIfNonNull(x.left(), stack::push);
            acceptIfNonNull(x.right(), stack::push);

            action.act(x.payload());
        }
    }

    private void acceptIfNonNull(Node x, Consumer<Node> a) {
        if (x != null) {
            a.accept(x);
        }
    }
}
