package com.math.data.impl;

import com.math.data.List;
import org.junit.Assert;
import org.junit.Test;

public class ListTest {

    public List list;

    @Test
    public void emptyList() {
        Assert.assertTrue(list.isEmpty());

        List.Pointer head = list.head();
        Assert.assertTrue(head.isHead());

        Assert.assertEquals(head, head.next());
        Assert.assertEquals(head, head.next());
    }

    @Test(expected = RuntimeException.class)
    public void emptyListHeadGet() {
        List.Pointer head = list.head();
        head.get();
    }

    @Test
    public void insertHeadNext() {
        List.Pointer head = list.head();
        head.insertNext("1");

        List.Pointer first = head.next();
        Assert.assertEquals("1", first.get());

        Assert.assertEquals(head, first.next());
        Assert.assertEquals(first, head.prev());
        Assert.assertEquals(head, first.prev());
    }

    @Test
    public void insertHeadPrev() {
        List.Pointer head = list.head();
        head.insertPrev("1");

        List.Pointer last = head.prev();
        Assert.assertEquals("1", last.get());

        Assert.assertEquals(head, last.prev());
        Assert.assertEquals(last, head.next());
        Assert.assertEquals(head, last.next());
    }

    @Test
    public void removeHeadNext() {
        List.Pointer head = list.head();
        head.insertNext("1");

        head.removeNext();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void removeHeadPrev() {
        List.Pointer head = list.head();
        head.insertPrev("1");

        head.removePrev();
        Assert.assertTrue(list.isEmpty());
    }


}
