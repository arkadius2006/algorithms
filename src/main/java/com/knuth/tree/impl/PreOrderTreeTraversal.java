package com.knuth.tree.impl;

import com.knuth.linear.Queue;
import com.knuth.linear.linked.LinkedQueue;
import com.knuth.tree.Action;
import com.knuth.tree.Tree;
import com.knuth.tree.TreeTraversal;

import java.util.function.Consumer;


/**
 * Visits all tree nodes, each exactly one time, and performs an action at each node.
 * <p/>
 * Parent nodes are visited BEFORE children ("pre-order").
 */
public class PreOrderTreeTraversal implements TreeTraversal {

    public void traverse(Tree root, Action action) {
        Queue q = new LinkedQueue();
        q.enqueue(root);

        while (!q.isEmpty()) {
            Tree x = (Tree) q.dequeue();
            acceptIfNonNull(x.left(), q::enqueue);
            acceptIfNonNull(x.right(), q::enqueue);

            action.act(x.payload());
        }
    }

    private void acceptIfNonNull(Tree x, Consumer<Tree> a) {
        if (x != null) {
            a.accept(x);
        }
    }
}
