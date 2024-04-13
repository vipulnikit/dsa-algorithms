import java.util.Random;

public class QuickSort {
    // Randomized Quick Sort - TC: O(NlogN) | SC: O(logN) | Un-stable | In-place
    void sort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    void quickSort(int[] A, int l, int h) {
        if (l >= h)
            return;
        int randIdx = getRandomIndex(l, h);
        swap(A, l, randIdx);
        int p = partition(A, l, h);
        quickSort(A, l, p - 1);
        quickSort(A, p + 1, h);
    }

    int partition(int[] A, int l, int h) {
        int s = l + 1, e = h;
        while (s <= e) {
            if (A[s] <= A[l]) {
                s++;
            } else if (A[e] > A[l]) {
                e--;
            } else {
                swap(A, s, e);
                s++;
                e--;
            }
        }
        swap(A, l, e);
        return e;
    }

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    int getRandomIndex(int s, int e) {
        Random random = new Random();
        return random.nextInt(e - s + 1) + s;
    }
}
