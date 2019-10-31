package com.huawei;

import java.util.HashMap;
import java.util.Map;

/**
 * Function implementation uses hash table.
 */
public class HashMapFunction implements Function {
    private Map<Character,Character> table;
    private char[] keys;

    public HashMapFunction(String a, String b) {
        table = new HashMap<>(64); // ensure to keep all [a-z] with respect to default load factor 0.75

        for (int i = 0; i < a.length(); i += 1) {
            char from = a.charAt(i);
            char to = b.charAt(i);

            if (table.containsKey(from) && table.get(from) != to) {
                throw new RuntimeException("Impossible");
            }

            table.put(from, to);
        }

        // collect keys to char[]
        keys = new char[table.size()];
        int i = 0;
        for (Character x: table.keySet()) {
            keys[i] = x;
            i += 1;
        }
    }

    @Override
    public int map(char x) {
        Character val = table.get(x);

        return (val != null) ? val : -1;
    }

    @Override
    public char[] keys() {
        return new char[0];
    }
}
