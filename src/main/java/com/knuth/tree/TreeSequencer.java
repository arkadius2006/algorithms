package com.knuth.tree;

/**
 * Yields all tree nodes one by one.
 * <p/>
 * This is an alternative interface for tree traversal algorithm.
 * It is more flexible (and powerful) then {@link TreeTraversal}.
 * <p/>
 * Likewise, any implementation of this interface produces
 * some linear ordering of tree nodes.
 */
public interface TreeSequencer {

    Sequence enumerate(Node root);
}
