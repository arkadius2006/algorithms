package com.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// General note. Solution is not optimal (performance), but could be (and should be optimized).
// Just have no time.
// So focused on providing correct working solution.
public class Solution {

    // returns -1 if impossible
    public int findMinumumSteps(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }

        if (a.length() == 0) {
            return 0;
        }

        Map<Character, Character> graph = buildGraph(a, b);
        if (graph == null) {
            return -1;
        }

        Map<Character, List<Character>> invGraph = inverseGraph(graph);

        // in case all chars 'a'-'z' are used this is a special case, we cannot introduce new nodes
        Character freeCharacter = findNotUsedChar(graph);

        // Here main part of the algorithm starts.
        // Graph has the property: each node has <= 1 outgoing edges
        // since no char can transform into two different chars.
        // This could be seen as child-parent relationship. But the graph is not generally a tree because
        // loops are also possible.
        // Algorithms starts by finding a node that has no outgoing edges ("root") and
        // cutting it away with all incoming edges. The counter is incremented by number of edges removed.
        // If no such node found ("loop" case) one of edges is switched by introducing a new node. This breaks a loop.
        // Algorithm continues until there are no edges in graph.
        int operationCount = 0;
        while (graph.size() > 0) { // num edges > 0
            // find vertex that has no outgoing edges, but some incoming
            // delete all incoming edges, increment count by number of edges removed
            Character v = findEndpointVertex(graph, invGraph);
            if (v != null) {
                operationCount += removeFromGraph(v, graph, invGraph);
            } else {
                // break loop by introducing new vertex
                char x = findAnyEdge(graph);

                // remove all identity mapping (like a -> a)
                if (graph.get(x) == x) {
                    graph.remove(x);
                    continue;
                }

                Character y = freeCharacter;
                if (y == null) {
                    return -1;
                }

                // apply x -> y operation, modify graph respectfully (and inv graph)
                char z = graph.get(x);
                graph.remove(x);
                graph.put(y, z);
                List<Character> lst = invGraph.get(z);
                if (lst == null) {
                    lst = new ArrayList<>();
                    invGraph.put(z, lst);
                }
                lst.remove((Character)x); // cast, not to confused with index
                lst.add(y);
                operationCount += 1;

                // do the same trick again with x (it has no outgoing edges)
                operationCount += removeFromGraph(x, graph, invGraph);
            }
        }

        return operationCount;
    }

    // returns null if some vertex has > 1 outgoing edges
    private Map<Character, Character> buildGraph(String a, String b) {
        Map<Character, Character> g = new HashMap<>();

        for (int i = 0; i < a.length(); i += 1) {
            char from = a.charAt(i);
            char to = b.charAt(i);

            if (g.containsKey(from) && g.get(from) != to) {
                return null; // already has a different mapping, transformation is impossible
            }

            g.put(from, to);
        }

        return g;
    }

    private Character findEndpointVertex(Map<Character, Character> graph, Map<Character, List<Character>> invGraph) {
        for (char c = 'a'; c <= 'z'; c += 1) {
            List<Character> incoming = invGraph.get(c);
            if (!graph.containsKey(c) && incoming != null && incoming.size() > 0) {
                return c;
            }
        }

        return null;
    }


    // returns number of edges removed
    private int removeFromGraph(char c, Map<Character, Character> graph, Map<Character, List<Character>> invGraph) {
        // c has no outgoing edges
        List<Character> fromNodes = invGraph.get(c);
        invGraph.remove(c);
        for (char f : fromNodes) {
            graph.remove(f);
        }

        return fromNodes.size();
    }

    private Map<Character, List<Character>> inverseGraph(Map<Character, Character> graph) {
        Map<Character, List<Character>> invGraph = new HashMap<>();

        for (Map.Entry<Character, Character> entry: graph.entrySet()) {
            char a = entry.getKey();
            char b = entry.getValue();

            List<Character> lst = invGraph.get(b);
            if (lst == null) {
                lst = new ArrayList<>();
                invGraph.put(b, lst);
            }
            lst.add(a);
        }

        return invGraph;
    }

    private char findAnyEdge(Map<Character, Character> graph) {
        // could be optimized
        for (char c = 'a'; c <= 'z'; c += 1) {
            if (graph.containsKey(c) ) {
                return c;
            }
        }

        throw new IllegalStateException("Unexpected state. Graph is empty");
    }

    private Character findNotUsedChar(Map<Character, Character> graph) {
        // could be optimized
        for (char c = 'a'; c <= 'z'; c += 1) {
            if (!graph.containsKey(c) ) {
                return c;
            }
        }

        return null;
    }

}
