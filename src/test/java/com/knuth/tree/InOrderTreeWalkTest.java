package com.knuth.tree;

import com.knuth.tree.impl.InOrderTreeWalk;
import com.knuth.tree.impl.TreeBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InOrderTreeWalkTest {
    TreeWalk alg;

    @Before
    public void setUpAlgorithm() {
        alg = new InOrderTreeWalk();
    }

    @Test
    public void test() {
        TreeBuilder a = new TreeBuilder("a");

        TreeBuilder b = new TreeBuilder("b");
        a.left(b.build());

        TreeBuilder c = new TreeBuilder("c");
        a.right(c.build());

        StringBuilder sb = new StringBuilder();
        alg.walk(a.build(), sb::append);
        Assert.assertEquals("", "bac", sb.toString());
    }

}
