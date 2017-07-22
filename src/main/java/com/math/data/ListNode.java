package com.math.data;

import com.math.data.impl.ListException;

/**
 * All interface method could throw {@link com.math.data.StaleNodeListException}.
 */
public interface ListNode {

    /**
     * Trivial list consists of only one node: head. E.g. trivial list contains no data nodes.
     */
    boolean isListTrivial();

    /**
     * Returns next node in node circle, it could be either data node or head node.
     */
    ListNode next();

    /**
     * Returns prev node in node circle, ti could be either data node or head node.
     */
    ListNode prev();

    /**
     * Insert a new data node just after this node.
     *
     * @param data node data, not null
     */
    void insertNext(Object data);

    /**
     * Returns new data not just before this node.
     *
     * @param data no data, not null
     */
    void insertPrev(Object data);

    /**
     * Deletes data node just after this node.
     *
     * @throws ListException if the next node is head.
     */
    void removeNext() throws ListException;

    /**
     * Deletes data node just before this node.
     *
     * @throws ListException if the prev node is head.
     */
    void removePrev() throws ListException;
}
