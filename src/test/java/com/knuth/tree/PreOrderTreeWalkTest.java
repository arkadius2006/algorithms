package com.knuth.tree;

import com.knuth.tree.impl.PreOrderTreeWalk;
import com.knuth.tree.impl.TreeBuilder;
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
        TreeBuilder a = new TreeBuilder("a");

        StringBuilder sb = new StringBuilder();
        alg.walk(a.build(), sb::append);
        Assert.assertEquals("", "a", sb.toString());
    }

    @Test
    public void testTree() {
        TreeBuilder a = new TreeBuilder("a");

        TreeBuilder b = new TreeBuilder("b");
        a.left(b.build());

        TreeBuilder c = new TreeBuilder("c");
        a.right(c.build());

        StringBuilder sb = new StringBuilder();
        alg.walk(a.build(), sb::append);
        Assert.assertEquals("", "abc", sb.toString());

    }
}
