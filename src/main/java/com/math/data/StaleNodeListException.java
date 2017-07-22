package com.math.data;

public class StaleNodeListException extends ListException {

    public StaleNodeListException(ListNode node) {
        super(node, "Node is stale: " + node);
    }
}
