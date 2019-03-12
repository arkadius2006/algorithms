package com.knuth.tree;

import com.knuth.tree.impl.ForwardTreeTraversal;
import com.knuth.tree.impl.NodeBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ForwardTreeTraversalTest {
    TreeTraversal alg;

    @Before
    public void setUpAlgorithm() {
        alg = new ForwardTreeTraversal();
    }

    @Test
    public void testOne() {
        NodeBuilder root = new NodeBuilder();
        root.payload("1");

        StringBuilder sb = new StringBuilder();
        alg.traverse(root.build(), sb::append);
        Assert.assertEquals("", "1", sb.toString());
    }
}
