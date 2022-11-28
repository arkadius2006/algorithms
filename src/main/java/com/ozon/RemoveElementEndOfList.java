package com.ozon;


public class RemoveElementEndOfList {

    // Given linked list, remove n-th element from end of list (counting from end of list)
    //
    // This algorithms benefits from using additional O(n) memory
    // to use minimum possible number of next() operations on list
    // It uses only (L+1) next() operations on list, e.g. traverses list only once

    // todo: очередь можно реализовать как круговой массив, заинлайнить это в код
    // тогда не надо будет делать deq(), enq() просто записывать каждый новый элемент списка
    // в ячейке queueIndex и увеличивать этот индекс на 1 по модулю n+1
    // То есть самый новый элемент будет просто затирать самый старый элемент
    // код будет элегантнее, но чуть посложнее читать

    Node removeElementFromListEnd(Node head, int n) {
        // At every time queue contains (n+1) pointers
        // that point to consecutive positions in list
        // e.g. k, k+1, ..., k + n

        Queue<Node> queue = new Queue<>();

        // init queue: set pointers on positions 0, 1, .., n in list where "0" means head
        Node p = head;
        for (int i = 0; i < n + 1; i++) {

            // check early end of list => list contains < n elements, just return head
            if (p == null) {
                return head;
            }

            queue.enqueue(p);
            p = p.next;
        }


        // p point to the rightmost element in list next to the last added to queue
        // p could be null

        // forward rightmost pointer one step at a time
        // keep (n+1) last seen list elements in queue in correct order

        while (p != null) {

            // push newest element to the queue, oldest element is poped out
            queue.dequeue(); // pop out oldest element
            queue.enqueue(p);

            p = p.next;
        }

        // p == null: algorithm hits end of list
        // queue contains last (n+1) elements of list
        // q[0], q[1], ...., q[n]
        // and next element after q[n] is p == null
        // q[n] is the last element in list
        // q[1] is the element to be removed from queue

        // remove element from queue
        Node prv = queue.dequeue(); // q[0]
        Node cur = prv.next;
        prv.next = cur.next;

        return head;
    }

}

class Node {
    int val;
    Node next;
}

// just stub for illustrating purposes
class Queue<T> {

    void enqueue(T element) {
        throw new RuntimeException("Not implemented");
    }

    T dequeue() {
        throw new RuntimeException("Not implemented");
    }
}