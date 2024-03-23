public class Kadane {
    public static int solve(int[] A) {
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
        System.out.println(solve(A));
    }
}