package placement.prep;

public class CoinChange {
    // Unbounded Knapsack!
    private static int coinChange(int[] coin, int sum) {
        int n = coin.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i< n+1; i++) {
            for (int j = 0; j< sum+1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j < sum+1; j++) {
                int prevIndex = i-1;
                if (coin[prevIndex] <= j) {
                    t[i][j] = t[i][j-coin[i-1]] + t[prevIndex][j];
                } else {
                    t[i][j] = t[prevIndex][j];
                }
            }
        }

        return t[coin.length][sum];
    }

    public static void main(String[] args) {
        int[] coin = {1,2,3};
        int sum = 5;
        System.out.println("Max ways: " + coinChange(coin, sum));
    }
}
