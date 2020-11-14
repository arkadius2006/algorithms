package com.knuth.tsorting;

/**
 * Given digraph, arrange graph nodes in sequence
 * <pre>
 * a[1], a[2], ..., a[n]
 * </pre>
 * such that for each edge (a -> b) in digraph, node a precedes node b in the above sequence.
 *
 * In other words a[i] -> a[j] implies i < j.
 *
 * We assume nodes are
 * <pre>
 * 0, 1, ..., n - 1
 * </pre>
 *
 * In case graph contains loops such ordering is impossible, algorithm should indicate this fact
 * by either throwing exception or returning special value.
 *
 * I prefer second option since this is algorithmic problem, and throwing exception is essentially
 * special return value.
 *
 * By convention, in this case algorithm returns any sequence of length < N,
 * where N is number of nodes in digraph.
 *
 * In case of success (ordering is possible) returned sequence length is always N. So client code
 * is capable of distinguishing both cases.
 *
 * For example, in case topological sorting is not possible, algorithm is free to return
 * empty sequence (length == 0 < N).
 */
public interface TopologicalSorting {

    int[] sort(DiGraph graph);
}
