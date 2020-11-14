package com.knuth.tsorting.impl;

import com.knuth.tsorting.DiGraph;
import com.knuth.tsorting.TopologicalSorting;

public class TopologicalSortingImpl implements TopologicalSorting {

    @Override
    public int[] sort(DiGraph g) {
        validateDigraph(g);
        
        return new int[0];
    }

    private void validateDigraph(DiGraph g) {
        throw new RuntimeException("Not implemented");

        // todo
        // check n > 0
        // check each source, destination within [0, n)
    }
}
