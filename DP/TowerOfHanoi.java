public class TowerOfHanoi {
    // TC: O(2^N) | SC: O(N)
    static void towerOfHanoi(int N, char from_rod, char to_rod, char temp_rod) {
        if (N == 0) {
            return;
        }
        towerOfHanoi(N - 1, from_rod, temp_rod, to_rod);
        System.out.println("Move disk " + N + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(N - 1, temp_rod, to_rod, from_rod);
    }

    public static void main(String args[]) {
        // A, B and C are names of rods
        towerOfHanoi(3, 'A', 'C', 'B');
    }
}
