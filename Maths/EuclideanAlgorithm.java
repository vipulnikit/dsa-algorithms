// Find gcd(a, b).
public class EuclideanAlgorithm {
    // TC: O(log(min(a, b)))
    int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
