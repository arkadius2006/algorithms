package com.math.data.impl;

import com.math.data.DataListNode;
import com.math.data.HeadListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListTest {

    HeadListNode head;

    @Before
    public void setUp() {
        head = new ImplHeadListNode();
    }

    @Test
    public void emptyList() {
        Assert.assertTrue(head.isListEmpty());

        Assert.assertEquals(head, head.next());
        Assert.assertEquals(head, head.next());
    }

    @Test
    public void insertHeadNext() {
        head.insertNext("1");

        DataListNode first = (DataListNode) head.next();
        Assert.assertEquals("1", first.getData());

        Assert.assertEquals(head, first.next());
        Assert.assertEquals(first, head.prev());
        Assert.assertEquals(head, first.prev());
    }

    @Test
    public void insertHeadPrev() {
        head.insertPrev("1");

        DataListNode last = (DataListNode) head.prev();
        Assert.assertEquals("1", last.getData());

        Assert.assertEquals(head, last.prev());
        Assert.assertEquals(last, head.next());
        Assert.assertEquals(head, last.next());
    }

    @Test
    public void removeHeadNext() {
        head.insertNext("1");

        head.removeNext();
        Assert.assertTrue(head.isListEmpty());
    }

    @Test
    public void removeHeadPrev() {
        head.insertPrev("1");

        head.removePrev();
        Assert.assertTrue(head.isListEmpty());
    }
}
