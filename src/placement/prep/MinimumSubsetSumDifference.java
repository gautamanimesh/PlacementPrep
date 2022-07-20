package placement.prep;

public class MinimumSubsetSumDifference {

    private static int[] subsetSum (int[] arr, int sum) {
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                int prevIndex = i-1;
                if (j - arr[prevIndex] >= 0) {
                    t[i][j] = t[prevIndex][j - arr[prevIndex]] || t[prevIndex][j];
                } else {
                    t[i][j] = t[prevIndex][j];
                }
            }
        }

        int[] ans = new int[sum/2];
        int ind = 0;
        for (int j = 0; j <= sum / 2; j++) {
            if (t[n][j]) {
                ans[ind++] = j;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        int range = 0;

        for (int j: arr) {
            range += j;
        }

        int min = Integer.MAX_VALUE;
        int[] res = subsetSum(arr, range);
        for (int j: res) {
            min = Math.min(min, range - 2*j);
        }

        System.out.println(min);
    }
}
