package com.math.data;

public interface Factory {


    /**
     * Unbounded stack.
     */
    Stack newStack();

    /**
     * Bounded stack.
     */
    Stack newStack(int capacity);

    /**
     * Unbounded queue.
     */
    Queue newQueue();

    /**
     * Bounded queue.
     */
    Queue newQueue(int capacity);


    /**
     * Unbounded deque.
     */
    Deque newDeque();

    /**
     * Bounded deque.
     */
    Deque newDeque(int capacity);

    /**
     * List.
     */
    ListNode newHeadListNode();

    // ===
    // primitive versions for byte, int, long
    // ===

    ByteStack newByteStack(int capacity);

    IntStack newIntStack(int capacity);

    LongStack newLongStack(int capacity);

    ByteQueue newByteQueue(int capacity);

    IntQueue newIntQueue(int capacity);

    LongQueue newLongQueue(int capacity);

    ByteDeque newByteDeque(int capacity);

    IntDeque newIntDeque(int capacity);

    LongDeque newLongDeque(int capacity);
}
