package com.huawei;

/**
 * We need a data structure to keep problem graph.
 *
 * The problem graph is a function, e.g. each character x in the first string
 * is to be transformed to some character y in the second string.
 * Thus, it is a function partially defined on character set.
 *
 * I choose to move it to separate interface for tow reasons:
 * 1. Make algorithm clean and not cluttered with details of how this data structure is implemented
 * 2. Different implementations are possible. We can use a hash table to keep mappings with O(1) access time average,
 * or we can use plain int[] array with index ranging 'a'-'z' code points.
 */
interface CharacterFunction {

    /**
     *  Applies function, or returns -1 if function not defined.
     *  In problem terms: given char x in string A return char in string B.
     */
    int map(char x);

    /**
     * Returns all distinct points where function is defined.
     * In problem terms: all distinct characters in string A.
     */
    char[] keys();
}
