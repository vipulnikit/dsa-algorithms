public class InsertionSort {
    // TC: O(N^2) | SC: O(1) | Stable | In-place
    void sort(int[] A) {
        int N = A.length;
        for (int i = 1; i < N; i++) {
            int j, temp = A[i];
            for (j = i - 1; j >= 0; j--) {
                if (temp < A[j])
                    A[j + 1] = A[j];
                else
                    break;
            }
            A[j + 1] = temp;
        }
    }
}
