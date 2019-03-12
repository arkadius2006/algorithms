package com.knuth.tree;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;


/**
 * Produces a sequence of all tree nodes in "forward" order:
 * parent nodes appear before children in the sequence.
 */
public class ForwardTreeTraversal implements TreeTraversal {

    public void traverse(Node root, Action action) {
        Stack stack = new LinkedStack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node x = (Node) stack.pop();

            if (x != null) {
                Object payload = x.payload();
                stack.push(x.left());
                stack.push(x.right());

                action.act(payload);
            }
        }
    }
}
