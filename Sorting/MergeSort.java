public class MergeSort {
    // TC: O(NlogN) | SC: O(N) | Stable | Not In-place
    void sort(int[] A) {
        mergeSort(A, 0, A.length - 1);
    }
    
    void mergeSort(int[] A, int l, int h) {
        if (l == h)
            return;
        int mid = (l + h) / 2;
        mergeSort(A, l, mid);
        mergeSort(A, mid + 1, h);
        merge(A, l, h);
    }

    void merge(int[] A, int l, int h) {
        int mid = (l + h) / 2;
        int i = l, j = mid + 1, k = 0;
        int[] temp = new int[h - l + 1];
        while (i <= mid && j <= h) {
            if (A[i] <= A[j]) {     // <= makes this algo stable
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = A[i++];
        }
        while (j <= h) {
            temp[k++] = A[j++];
        }
        for (int x = l; x <= h; x++) {
            A[x] = temp[x - l];
        }
    }
}
