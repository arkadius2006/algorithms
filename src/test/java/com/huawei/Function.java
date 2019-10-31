package com.huawei;

/**
 * Problem representation as function (graph).
 *
 * I chose to move it to separate interface for two reasons:
 * 1. Make algorithm clean and not cluttered with data structure implementation details
 * 2. Different implementations are possible (hash table, array, etc).
 */
interface Function {

    /**
     *  Applies function, or returns -1 if function not defined.
     *  In problem terms: given char x in string A return char y in string B.
     *  In graph terms: (x, y) is graph edge.
     */
    int map(char x);

    /**
     * Returns all distinct points where function is defined.
     * In problem terms: all distinct characters in string A.
     * In graph terms: all non-terminal nodes.
     */
    char[] keys();
}
