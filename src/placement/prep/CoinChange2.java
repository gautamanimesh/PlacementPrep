package placement.prep;

public class CoinChange2 {

    // Using min. no. of coins
    private static int coinChange (int[] coin, int sum) {
        int n = coin.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE - 1;
                }
                if (j == 0 && i > 0) {
                    t[i][j] = 0;
                }
                if (j > 0 && i == 1 && j % coin[i-1] == 0) {
                    t[1][j] = j / coin[i-1];
                } else {
                    t[1][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                int prevIndex = i-1;
                if (j - coin[prevIndex] >= 0) {
                    t[i][j] = Math.min(1 + t[i][j - coin[prevIndex]], t[prevIndex][j]);
                } else {
                    t[i][j] = t[prevIndex][j];
                }
            }
        }

        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] coin = {3,4,5};
        int sum = 5;
        System.out.println(coinChange(coin, sum));
    }
}
