package com.knuth.tree;

/**
 * Generates all tree nodes one by one.
 * <p/>
 * This is an alternative interface for tree traversal algorithm.
 * It is more flexible (and powerful) than {@link TreeWalk}.
 * <p/>
 * Essentially, an algorithm that implements this interface
 * produces some linear ordering of tree nodes.
 */
public interface TreeSequencer {

    Sequence enumerate(Tree root);
}
