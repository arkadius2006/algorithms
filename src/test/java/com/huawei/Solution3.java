package com.huawei;

public class Solution3 {

    // returns minimum number of operations or -1 if transformation is impossible
    public int solve(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }

        if (a.length() == 0) {
            return 0;
        }

        CharacterFunction function = buildGraph(a, b);
        if (function == null) {
            return -1;
        }

        return solveGraph(function);
    }

    // collect a_i -> b_i mappings to hash table or similar structure
    private CharacterFunction buildGraph(String a, String b) {

    }

    private int solveGraph(CharacterFunction g) {

    }
}
