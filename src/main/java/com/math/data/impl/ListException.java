package com.math.data.impl;

import com.math.data.ListNode;

public class ListException extends RuntimeException {
    private final ListNode node;

    public ListException(ListNode node, String message) {
        super(message);
        this.node = node;
    }
}
