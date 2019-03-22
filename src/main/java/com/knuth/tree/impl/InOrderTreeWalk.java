package com.knuth.tree.impl;

import com.knuth.linear.Stack;
import com.knuth.linear.linked.LinkedStack;
import com.knuth.tree.Tree;
import com.knuth.tree.TreeWalk;

import java.util.function.Consumer;

public class InOrderTreeWalk implements TreeWalk {

    @Override
    public void walk(Tree a, Consumer<Tree> q) {
        Stack s = new LinkedStack();

        while (true) {
            if (a != null) {
                s.push(a);
                a = a.left();
            } else if (!s.isEmpty()) {
                a = (Tree) s.pop();
                q.accept(a);
                a = a.right();
            } else {
                break;
            }
        }
    }
}
