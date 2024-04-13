import java.util.Random;

public class QuickSort {
    // Randomized Quick Sort - TC: O(NlogN) | SC: O(logN) | Un-stable | In-place
    void sort(int[] A) {
        int s = 0, e = A.length - 1;
        quickSort(A, s, e);
    }

    void quickSort(int[] A, int s, int e) {
        if (s >= e)
            return;
        int randIdx = getRandomIndex(s, e);
        swap(A, s, randIdx);
        int p = partition(A, s, e);
        quickSort(A, s, p - 1);
        quickSort(A, p + 1, e);
    }

    int partition(int[] A, int s, int e) {
        int l = s + 1, r = e;
        while (l <= r) {
            if (A[l] <= A[s]) {
                l++;
            } else if (A[r] > A[s]) {
                r--;
            } else {
                swap(A, l, r);
                l++;
                r--;
            }
        }
        swap(A, s, r);
        return r;
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

    public static void main(String[] args) {
        int[] a = {2,3,5,7,1};
        QuickSort s = new QuickSort();
        s.sort(a);
        for(int x: a)
            System.out.print(x + " ");
    }
}
