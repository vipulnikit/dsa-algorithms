// Count number of occurrences of pattern string P in text string T.

public class RabinKarpAlgo {
    // Avg, Best Case TC: O(lenT + lenP) | Worst Case TC: O(lenT*lenP) (very rare)
    // SC: O(1)
    int rabinKarp(String T, String P) {
        // T = "deabcd", P = "abc"
        int lenT = T.length(), lenP = P.length(), prime = 37, mod = 1000000007;
        long pHash = 0, curTHash = 0;
        long powLenP = 0, prevPow = 0, curPow = 1;
        for (int i = lenP - 1; i >= 0; i--) {
            // pHash = a*37^2 + b*37^1 + c*37^0
            pHash = (pHash + (P.charAt(i) - 'a' + 1) * curPow) % mod;
            // curHash = d*37^2 + e*37^1 + a*37^0
            curTHash = (curTHash + (T.charAt(i) - 'a' + 1) * curPow) % mod;
            prevPow = curPow;
            curPow = (curPow * prime) % mod;
        }
        // storing prevPow to avoid calculating (prime^(lenP-1))%mod in leftHash=(leftChar*powLenP)%mod every time below.
        // Here, powLenP = (prime^(lenP-1))%mod;
        powLenP = prevPow;
        int count = matchHash(curTHash, pHash, T, P, 0, lenP - 1);
        // sliding window of lenP
        for (int i = lenP; i < lenT; i++) {
            int leftChar = T.charAt(i - lenP) - 'a' + 1;
            int rightChar = T.charAt(i) - 'a' + 1;
            long leftHash = (leftChar * powLenP) % mod;
            long rightHash = rightChar;
            curTHash = (curTHash - leftHash + mod) % mod;   // delete left char's hash
            curTHash = (curTHash * prime) % mod;            // increase power of remaining chars
            curTHash = (curTHash + rightHash) % mod;        // add right char's hash
            count += matchHash(curTHash, pHash, T, P, i - lenP + 1, i);
        }
        return count;
    }

    int matchHash(long tHash, long pHash, String T, String P, int startT, int endT) {
        if (tHash == pHash) {
            int startP = 0;
            while (startT <= endT) {
                if (T.charAt(startT) != P.charAt(startP))
                    return 0;
                startT++; startP++;
            }
            return 1;
        }
        return 0;
    }
}
