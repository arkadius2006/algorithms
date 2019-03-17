package com.problems;

public class MaxSubArrayDivideAndConquerSolution implements MaxSubArray {

    @Override
    public int maxSubArray(int[] a) {
        if (a.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        return maxSubArray(a, 0, a.length);
    }

    // i - inclusive, k - exclusive
    // range contains (k - i) elements
    // assert i < k, e.g. n > 0
    public int maxSubArray(int[] a, int i, int k) {
        int n = k - i;

        if (n == 1) {
            return a[i];
        }

        if (n == 2) {
            return max(a[i], a[i+1], a[i] + a[i+1]);
        }

        // at this point n >= 3
        // so both left and right half are not empty

        int mid = (i + k)/2;

        // solve left subarray, not inclusive mid
        int leftmax = maxSubArray(a, i, mid);

        // solve right subarray, not inclusive mid
        int rightmax = maxSubArray(a, mid + 1, k);

        // now, consider subarrays that contains mid element

        // find max sequence that is adjucent to mid from left
        int leftmidmax = maxSubArrayTo(a, i, mid);

        // find max sequence that is adjucent to mid element from right, prob empty
        int rightmidmax = maxSubArrayFrom(a, mid + 1, k);

        // sum up
        int midmax = leftmidmax + a[mid] + rightmidmax;

        // choose max
        return max(leftmax, rightmax, midmax);
    }

    public int maxSubArrayFrom(int[] a, int left, int right) {
        int sum = 0; // empty sequence is also considered!
        int max = sum;

        for (int k = left; k < right; k += 1) {
            sum += a[k];

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    public int maxSubArrayTo(int[] a, int left, int right) {
        int sum = 0; // empty sequence is also considered!
        int max = sum;

        for (int k = right - 1; k >= left; k -= 1) {
            sum += a[k];

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    private int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

}
