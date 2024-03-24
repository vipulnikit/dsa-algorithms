// Given an array A[] of integers, find sum of all subarrays sum.
public class ContributionTechnique {
    // TC: O(N) | SC: O(1)
    public static int contribution(int[] A) {
        int N = A.length, sum = 0;
        for (int i = 0; i < N; i++) {
            // count of subarrays where A[i] can be present = (No. of starts) * (No. of
            // ends)
            int count = (i + 1) * (N - i);
            sum += A[i] * count;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = { 3, -2, 4, -1, 2, 6 };
        System.out.print(contribution(A));
    }
}
