public class FibonacciSeries {
    void fibonacci(int N) {
        // Recursive Approach
        // TC: O(N*(2^N)) | SC: O(N)
        for (int i = 1; i <= N; i++) {
            System.out.print(fibRec(i) + " ");
        }
        System.out.println();

        // Iterative Approach
        // TC: O(N) | SC: O(1)
        System.out.print(1 + " ");
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            int c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }
    }

    // Nth Fibonacci Series
    int fibRec(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        return fibRec(N - 1) + fibRec(N - 2);
    }
}