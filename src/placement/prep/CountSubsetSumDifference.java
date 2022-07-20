package placement.prep;

public class CountSubsetSumDifference {

    private static int countSubsetSumDifference(int[] arr, int sum) {
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                int prevIndex = i-1;
                if (j - arr[prevIndex] >= 0) {
                    t[i][j] = t[prevIndex][j - arr[prevIndex]] + t[prevIndex][j];
                } else {
                    t[i][j] = t[prevIndex][j];
                }
            }
        }

        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        int sum = 0;
        for (int j: arr) {
            sum += j;
        }
        sum += diff;
        sum /= 2;
        System.out.println(countSubsetSumDifference(arr, sum));
    }
}
