// Given an array of distinct integers, check if there exists a pair (i, j) such that A[i] + A[j] = k where i != j.

import java.util.*;

public class TwoSumProblem {
    // HashSet Approach
    // TC: O(N) | SC: O(N)
    boolean twoSumHashSet(int arr[], int k) {
        Set<Integer> set = new HashSet<>();
        for (int num: arr) {
            if (set.contains(k - num))
                return true;
            set.add(num);
        }
        return false;
    }

    // Two Pointers Approach
    // TC: O(NlogN) | SC: O(logN) -> quick sort
    boolean twoSumTwoPointers(int arr[], int k) {
        Arrays.sort(arr);
        int l = 0, h = arr.length - 1;
        while (l < h) {
            if (arr[l] + arr[h] == k)
                return true;
            if (arr[l] + arr[h] > k)
                h--;
            else
                l++;
        }
        return false;
    }
}
