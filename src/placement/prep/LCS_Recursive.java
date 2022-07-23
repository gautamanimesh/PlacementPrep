package placement.prep;

public class LCS_Recursive {

    private static int lcsRecursive (String X, String Y, int n, int m) {
        if (n == 0 || m == 0) return 0;
        if (X.charAt(n-1) == Y.charAt(m-1)) {
            return 1 + lcsRecursive(X, Y, n-1, m-1);
        } else {
            return Math.max(lcsRecursive(X, Y, n-1, m), lcsRecursive(X, Y, n, m-1));
        }
    }

    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        System.out.println(lcsRecursive(X, Y, X.length(), Y.length()));
    }
}
