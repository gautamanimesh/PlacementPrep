package placement.prep;

public class UnboundedKnapsack {

    private static int unboundedKnapsack (int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] t = new int[n+1][W+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int prevIndex = i-1;
                if (j - wt[prevIndex] >= 0) {
                    t[i][j] = Math.max(val[prevIndex] + t[i][j - wt[prevIndex]], t[prevIndex][j]);
                } else {
                    t[i][j] = t[prevIndex][j];
                }
            }
        }

        return t[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {1,2,3,4};
        int[] price = {2,1,5,7};
        int W = 8;
        System.out.println(unboundedKnapsack(wt, price, W));
    }
}
