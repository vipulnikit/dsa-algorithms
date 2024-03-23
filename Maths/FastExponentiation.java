public class FastExponentiation {
    // Find (a ^ b) % m. a, b & m are all integers.

    // TC: O(log(b)) | SC: O(log(b))
    static int recPow(int a, int b, int m) {
        if (a == 0 || b == 0) {
            return a == 0 ? 0 : 1;
        }
        long res = recPow(a, b / 2, m);
        res = (res * res) % m;
        if (b % 2 == 1) {
            res = (res * a) % m;
        }
        res = (res + m) % m;    // for handling % of -ve no.s
        return (int) res;
    }

    // TC: O(log(b)) | SC: O(1)
    static int iterPow(int a, int b, int m) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (res * a) % m;
            }
            a = (a * a) % m;
            b /= 2;
        }
        res = (res + m) % m;    // for handling % of -ve no.s
        return (int) res;
    }

    public static void main(String[] args) {
        int mod = 1000000009;
        System.out.println(recPow(3, 4, mod));
        System.out.println(iterPow(3, 4, mod));
        System.out.println(recPow(2, 5, mod));
        System.out.println(iterPow(2, 5, mod));
    }
}
