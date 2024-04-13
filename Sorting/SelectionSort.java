public class SelectionSort {
    // TC: O(N^2) | SC: O(1) | Un-stable | In-place
    void sort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int min = A[i], minIdx = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    minIdx = j;
                }
            }
            swap(A, i, minIdx);
        }
    }

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
