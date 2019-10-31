package com.huawei;

import java.util.*;

public class Problem {

    public int solve(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }

        if (a.length() == 0) {
            return 0;
        }

        // Step 1. Build graph
        Graph graph = buildGraph(a, b);
        if (graph == null) {
            return -1;
        }


        // Step 2. Collect roots
        Set<Character> roots = getRoots(graph);

        // Step 3. Mark each tree
        Set<Character> unmarked = getNodes(graph);
        for (char r : roots) {
            Set<Character> found = search(r, graph);
            unmarked.removeAll(found);
        }

        // Step 5. Find number of components in unmarked part of graph
        // Do it the same way: visit each component one by one
        while (!unmarked.isEmpty()) {
            char x = takeAny(unmarked);
            char y = followUntilDuplicateFound(x);
            // remove edge x -> g(x)

            Set<Character> found = search(r, graph);
            unmarked.removeAll(found);
        }
    }

    private Graph buildGraph(String a, String b) {
        Map<Character, Character> map = new HashMap<>(64);

        for (int i = 0; i < a.length(); i += 1) {
            char from = a.charAt(i);
            char to = b.charAt(i);

            if (map.containsKey(from) && map.get(from) != to) {
                return null; // already has a different mapping, transformation is impossible
            }

            map.put(from, to);
        }

        return new Graph(map);
    }

    private Set<Character> getNodes(Graph g) {

    }

    private Set<Character> getRoots(Graph g) {
        Set<Character> roots = new HashSet<>();

        for (Map.Entry<Character, Character> entry: g.map.entrySet()) {
            char to = entry.getValue();

            if (!g.map.containsKey(to)) {
                roots.add(to);
            }
        }

        return roots;
    }

    private Set<Character> search(char root, Graph graph) {
        // use BFS, need inverse mappings
    }
}

class Graph {
    Map<Character, Character> map;


    Graph(Map<Character, Character> map) {
        this.map = map;
    }
}
