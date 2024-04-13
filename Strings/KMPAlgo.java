// Count number of occurrences of pattern string P in text string T.

public class KMPAlgo {
    // TC: O(lenT + lenP) | SC: O(lenT + lenP)
    int kmp(String T, String P) {
        // T = "deabcd", P = "abc"
        String S = P + "$" + T;
        int n = S.length();
        int[] lps = new int[n];
        lps[0] = 0;
        for (int i = 1; i < n; i++) {
            int x = lps[i - 1];
            while (S.charAt(x) != S.charAt(i)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (lps[i] == P.length()) {
                count++;
            }
        }
        return count;
    }
}
