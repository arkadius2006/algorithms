package com.math.data.impl;

import com.math.data.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListTest {

    ListNode head;

    @Before
    public void setUp() {
        head = LinkedListNode.newHeadListNode();
    }

    @Test
    public void emptyList() {
        Assert.assertTrue(head.isCircle());
        Assert.assertTrue(head.isHeadNode());

        Assert.assertEquals(head, head.next());
        Assert.assertEquals(head, head.next());
    }

    @Test(expected = RuntimeException.class)
    public void emptyListHeadGet() {
        head.get();
    }

    @Test
    public void insertHeadNext() {
        head.insertNext("1");

        ListNode first = head.next();
        Assert.assertEquals("1", first.get());

        Assert.assertEquals(head, first.next());
        Assert.assertEquals(first, head.prev());
        Assert.assertEquals(head, first.prev());
    }

    @Test
    public void insertHeadPrev() {
        head.insertPrev("1");

        ListNode last = head.prev();
        Assert.assertEquals("1", last.get());

        Assert.assertEquals(head, last.prev());
        Assert.assertEquals(last, head.next());
        Assert.assertEquals(head, last.next());
    }

    @Test
    public void removeHeadNext() {
        head.insertNext("1");

        head.removeNext();
        Assert.assertTrue(head.isCircle());
    }

    @Test
    public void removeHeadPrev() {
        head.insertPrev("1");

        head.removePrev();
        Assert.assertTrue(head.isCircle());
    }


}
