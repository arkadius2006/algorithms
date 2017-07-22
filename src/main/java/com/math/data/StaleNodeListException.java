package com.math.data;

import com.math.data.impl.ListException;

public class StaleNodeListException extends ListException {

    public StaleNodeListException(ListNode node) {
        super(node, "Node is stale: " + node);
    }
}
