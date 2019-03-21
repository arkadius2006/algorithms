package com.knuth.tree;

import com.knuth.tree.impl.PreOrderTreeWalk;
import com.knuth.tree.impl.NodeBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PreOrderTreeWalkTest {
    TreeWalk alg;

    @Before
    public void setUpAlgorithm() {
        alg = new PreOrderTreeWalk();
    }

    @Test
    public void testOne() {
        NodeBuilder a = new NodeBuilder("a");

        StringBuilder sb = new StringBuilder();
        alg.walk(a.build(), sb::append);
        Assert.assertEquals("", "a", sb.toString());
    }

    @Test
    public void testTree() {
        NodeBuilder a = new NodeBuilder("a");

        NodeBuilder b = new NodeBuilder("b");
        a.left(b.build());

        NodeBuilder c = new NodeBuilder("c");
        a.right(c.build());

        StringBuilder sb = new StringBuilder();
        alg.walk(a.build(), sb::append);
        Assert.assertEquals("", "abc", sb.toString());

    }
}
