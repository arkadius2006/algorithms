package com.huawei;

import java.util.HashSet;
import java.util.Set;

/**
 * Algorithm. Given a function, finds number of loops in graph representation of function.
 */
public class LoopCounter {

    public int findLoops(CharacterFunction func) {
        Set<Character> visited = new HashSet<>();

        int loops = 0;
        for (char x: func.keys()) {
            loops += searchFrom(func, x, visited);
        }

        return loops;
    }

    private int searchFrom(CharacterFunction func, char x, Set<Character> marked) {
        Set<Character> seen = new HashSet<>();

        while (true) {
            if (seen.contains(x)) {
                return 1;
            }

            if (marked.contains(x)) {
                return 0;
            }

            seen.add(x);
            marked.add(x);
            int y = func.map(x);
            if (y == -1) {
                return 0;
            }

            x = (char) y;
        }
    }
}
