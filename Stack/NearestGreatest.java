// Given an array of integers A[], for every index i, find the nearest greatest element on left of A[i].

import java.util.*;

public class NearestGreatest {
    // TC: O(n) | SC: O(n)
    int[] NGL(int[] A) {
        int[] ans = new int[A.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stk.isEmpty() && stk.peek() <= A[i]) {
                stk.pop();
            }
            if (stk.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stk.peek();
            stk.push(A[i]);
        }
        return ans;
    }
}
