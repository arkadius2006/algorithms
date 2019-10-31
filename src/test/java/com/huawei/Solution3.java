package com.huawei;

/**
 * Returns minimum number of operations or -1 if transformation is impossible.
 */
public class Solution3 {

    public int solve(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }

        if (a.length() == 0) {
            return 0;
        }

        // build problem graph/function
        Function func = buildFunc(a, b);
        if (func == null) {
            return -1;
        }

        return solve(func);
    }

    // collect a_i -> b_i mappings to hash table or similar structure
    private Function buildFunc(String a, String b) {
        return null;
    }

    private int solve(Function func) {
        int edges = countEdges(func);
        int loops = countLoops(func);
        int trivialLoops = countTrivialLoops(func);
        return edges + loops - trivialLoops;
    }

    private int countEdges(Function func) {
        return func.keys().length; // each non terminal node x means single edge x->y
    }

    private int countLoops(Function func) {
        return new LoopCounter().findLoops(func);
    }

    private int countTrivialLoops(Function func) {
        int counter = 0;
        for (char x: func.keys()) {
            int y = func.map(x);
            if (y == x) {
                counter += 1;
            }
        }

        return counter;
    }
}
