package com.knuth.tree;

import java.util.Iterator;

/**
 * Impl note. Designer decided against using {@link Iterator} interface
 * which contains 2 separate methods: the first for checking whether there are more
 * elements in collection, and the second to yield next element in collection, if it
 * exists.
 * <p/>
 * In most applications, both methods perform some kind of searching for
 * the next item in the sequence, which results either in next item found,
 * or discovering end of sequence. Using coding pattern
 * <pre>
 *     Iterator i = ...
 *
 *     while (i.hasNext()) {
 *         Object o = i.next();
 *         ...
 *     }
 * </pre>
 * results in double-performing this search procedure, or additional code lines
 * to cache value found at {@code i.hasNext()} to yield at {@code i.next()} step.
 * This clutters code.
 * <p/>
 * Instead author suggest coding pattern
 * <pre>
 *     Sequence s = ...
 *
 *     Item i = s.next();
 *     while (!i.isEmpty()) {
 *         Object o = i.value();
 *         ...
 *
 *         i = s.next();
 *     }
 * </pre>
 */
public interface Sequence {

    /**
     * Yields next item in the sequence, or {@code null} if end of sequence is reached.
     */
    Item next();
}
