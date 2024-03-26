// Find prime numbers from 2 to N.

import java.util.*;

public class SieveOfEratosthenes {
    // TC: O(Nlog(logN)) | SC: O(N)
    List<Integer> findPrime(int N) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (isPrime[i])
                primes.add(i);
        }
        return primes;
    }
}
