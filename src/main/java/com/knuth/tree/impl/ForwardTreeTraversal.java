package com.knuth.tree.impl;

import com.knuth.linear.Queue;
import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedQueue;
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
        Queue q = new LinkedQueue();
        q.enqueue(root);

        while (!q.isEmpty()) {
            Node x = (Node) q.dequeue();
            acceptIfNonNull(x.left(), q::enqueue);
            acceptIfNonNull(x.right(), q::enqueue);

            action.act(x.payload());
        }
    }

    private void acceptIfNonNull(Node x, Consumer<Node> a) {
        if (x != null) {
            a.accept(x);
        }
    }
}
