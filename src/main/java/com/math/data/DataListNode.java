package com.math.data;

/**
 * All methods could throw {@link com.math.data.StaleNodeListException}
 */
public interface DataListNode extends ListNode {

    /**
     * Returns node data.
     */
    Object getData();

    /**
     * Sets node data.
     *
     * @param o node data, nul null.
     */
    void setData(Object o);
}
