// Given an array of integers A[], find the sum of the contiguous subarray within A[] with the largest sum. 
public class Kadane {
    // TC: O(N) | SC: O(1)
    int kadane(int[] A) {
        int N = A.length, ans = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }
}