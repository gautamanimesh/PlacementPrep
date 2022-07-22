package placement.prep;

// Unbounded Knapsack!
public class RodCutting {

    private static int rodCutting (int[] length, int[] price, int N) {
        int n = price.length;
        int[][] t = new int[n+1][N+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < N+1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < N+1; j++) {
                int prevIndex = i-1;
                if (j - length[prevIndex] >= 0) {
                    t[i][j] = Math.max(price[prevIndex] + t[i][j - length[prevIndex]], t[prevIndex][j]);
                } else {
                    t[i][j] = t[prevIndex][j];
                }
            }
        }

        return t[n][N];
    }

    public static void main(String[] args) {
        int[] length = {1,2,3,4};
        int[] price = {2,1,5,7};
        int N = 8;
        System.out.println(rodCutting(length, price, N));
    }
}
