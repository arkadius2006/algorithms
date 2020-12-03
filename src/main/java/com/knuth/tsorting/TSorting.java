package com.knuth.tsorting;

/**
 * Given digraph, arrange graph nodes in sequence
 * <pre>
 * a[1], a[2], ..., a[n]
 * </pre>
 * such that for each edge (a -> b) in digraph, node a precedes node b in the above sequence.
 * <p>
 * In other words a[i] -> a[j] implies i < j.
 * <p>
 * We assume nodes are
 * <pre>
 * 0, 1, ..., n - 1
 * </pre>
 * <p>
 * In case graph contains loops such ordering is impossible, algorithm should indicate this fact
 * by either throwing exception or returning special value.
 * <p>
 * I prefer second option since this is algorithmic problem, and throwing exception is essentially
 * special return value.
 * <p>
 * By convention, in this case algorithm returns any sequence of length < N,
 * where N is number of nodes in digraph.
 * <p>
 * In case of success (ordering is possible) returned sequence length is always N. So client code
 * is capable of distinguishing both cases.
 * <p>
 * For example, in case topological sorting is not possible, algorithm is free to return
 * empty sequence (length == 0 < N). todo ERROR loop could have length n.
 */
public class TSorting {

    /**
     * @param n     number of nodes
     * @param edges edges
     * @return (a) complete node sequence such that
     * <pre>
     *     a[i] -> a[j] implies i < j
     * </pre>
     * in case graph contains no loop.
     * <p>
     * (b) loop sequence:
     * <pre>
     *     a[0] -> a[1] -> ... ->  a[p - 1] -> a[0]
     * </pre>
     * where {@code p} is loop length ({@code <= n}).
     */
    public int[] sort(int n, Edge[] edges) {
        throw new RuntimeException("Not implemented");
    }
}
