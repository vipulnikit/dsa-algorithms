// Given an array of integers A[], count the no. of pairs (i, j) such that (i < j) and (A[i] > A[j]).
public class InversionCount {
    // TC: O(NlogN) | SC: O(N)
    int countPairs(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }
    
    int mergeSort(int[] A, int l, int h) {
        if (l == h)
            return 0;
        int mid = (l + h) / 2;
        int count = mergeSort(A, l, mid);
        count += mergeSort(A, mid + 1, h);
        count += merge(A, l, h);
        return count;
    }

    int merge(int[] A, int l, int h) {
        int mid = (l + h) / 2;
        int i = l, j = mid + 1, k = 0, count = 0;
        int[] temp = new int[h - l + 1];
        while (i <= mid && j <= h) {
            if (A[i] > A[j]) {
                count += mid - i + 1;
                temp[k++] = A[j++];
            } else {
                temp[k++] = A[i++];
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
        return count;
    }
}
