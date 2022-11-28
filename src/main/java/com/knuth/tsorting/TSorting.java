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
        // variables:
        //
        // T            - output sequence, queue
        // in_count[q]  - incoming edge count (to q)
        // ex[p]        - outgoing edge list (from p)
        // Z            - nodes with no incoming edges (zero incoming edge count)


        // init
        int[] in_count = new int[n];        // incoming edge count
        Queue[] ex = new Queue[n];          // outgoing edge list
        for (int p = 0; p < n; p += 1) {
            in_count[p] = 0;
            ex[p] = newQueue();
        }

        // compute initial in-degrees and ex-lists
        for (Edge e : edges) {
            int p = e.source;
            int q = e.destination;
            // todo check p, q are valid
            ex[p].push(q);
            in_count[q] += 1;
        }

        // find nodes that no one precedes, e.g. zero incoming degree
        Queue Z = newQueue();
        for (int p = 0; p < n; p += 1) {
            if (in_count[p] == 0) {
                Z.push(p);
            }
        }

        // init output sequence
        Queue T = newQueue();
        int k = 0;

        // main loop: find any Z-node, add it output sequence and remove from graph
        //
        // loop invariants:
        //
        // 1) in_count[q] is incoming edge count
        // 2) ex[p] is outgoing edge list
        // 3) T contains sequence a, b, .., r such that: a -> b -> .. -> r (arrow means edge)
        // 4) Z contains all nodes that have zero incoming degree
        // 5) T contains k elements
        while (!T.isEmpty()) {
            int p = Z.pop();

            // remove node from graph
            Queue endpoints = ex[p];
            while (!endpoints.isEmpty()) {
                // un-link edge from end point
                int q = endpoints.pop();

                // un-link edge from start point
                in_count[q] -= 1;

                // could have new Z-node
                if (in_count[q] == 0) {
                    Z.push(q);
                }
            }

            // add node to output sequence
            T.push(p);
            k += 1;
        }

        // Z is empty at this point
        // if (k < n) {
        //      cannot build t-sorting,
        //      nodes G\T make loop in some order
        // } else {
        //      T contains t-sorting
        // }

        // return T sequence in both cases,
        // client code could distinguish both cases by examining number of elements in T

        return toArray(T);
    }

    private Queue newQueue() {
        throw new RuntimeException();
    }

    private int[] toArray(Queue q) {
        throw new RuntimeException();
    }
}
