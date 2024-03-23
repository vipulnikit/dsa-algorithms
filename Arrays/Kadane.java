public class Kadane {
    // Given an array of integers A[], find the sum of the contiguous subarray within A[] with the largest sum. 

    // TC: O(N) | SC: O(1)
    public static int kadane(int[] A) {
        int N = A.length, ans = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            ans = Math.max(ans, sum);
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 2, -2, -1, 5, -1, -2, 3, 8 };
        System.out.println(kadane(A));
    }
}