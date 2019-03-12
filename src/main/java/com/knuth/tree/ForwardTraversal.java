package com.knuth.tree;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;

import java.util.function.Consumer;

/**
 * Produces a sequence of all tree nodes in "forward" order:
 * parent nodes appear before children in the sequence.
 */
public class ForwardTraversal implements Traversal {

    public void traverse(Node root, Consumer<Object> action) {
        Stack stack = new LinkedStack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node x = (Node) stack.pop();

            if (x != null) {
                Object payload = x.payload();
                stack.push(x.left());
                stack.push(x.right());

                action.accept(payload);
            }
        }
    }
}
