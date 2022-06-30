package placement.prep;

public class Knapsack {

    // Memoization:
    public static int knapsack (int[] wt, int[] price, int W, int n, int[][] t) {
        if (n == 0 || W == 0) return 0;
        if (t[n][W] != -1) return t[n][W];
        if (wt[n-1] <= W) {
            t[n][W] =  Math.max(price[n-1] + knapsack(wt,price,W-wt[n-1],n-1,t), knapsack(wt, price,W,n-1,t));
        } else {
            t[n][W] = knapsack(wt, price, W, n-1,t);
        }
        return t[n][W];
    }

    public static int knapsackTopDown (int[] wt, int[] price, int W, int n) {
        int[][] t = new int[n+1][W+1];

        for (int i=0; i<n+1; i++) {
            for (int j=0; j<W+1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<W+1; j++) {
                if (wt[i-1] <= j) {
                    t[i][j] = Math.max(price[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {1,2,3,4};
        int[] price = {2,1,5,7};
        int W = 8;
        int[][] t = new int[wt.length+1][W+1];
        for (int i=0; i<wt.length+1; i++) {
            for (int j=0; j<W+1; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println("Knapsack Memoized: " + knapsack(wt,price,W,wt.length,t));
        System.out.println("Knapsack Top-Down: " + knapsackTopDown(wt,price,W,wt.length));
    }
}
