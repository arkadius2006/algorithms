package com.tinkoff;

public class MaxSequence {

    int computeMaxSequence(int[] a) {
        // init
        State state = State.C;
        int count = 0;
        int prev_count = 0;
        int max = 0;

        // read each bit in turn, update FSM state and counts
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {    // ..1
                count++;

                if (count + prev_count > max) {
                    max = count + prev_count;
                }

                state = State.A;

                // a[i] == 0 from here
            } else if (state == State.A) {  // ..10
                prev_count = count;
                count = 0;
                state = State.B;
            } else if (state == State.B) {   // ..00
                prev_count = 0;
                state = State.C;
            }
            // other cases: no action
        }

        return max;
    }

    // FSM states
    enum State {
        A, // seen ...1 before
        B, // seen ..10 before
        C  // seen ..00 before or start of sequence
    }
}