package placement.prep;

public class CountOfSubsetSum {

    public static int countOfSubsetSum (int[] arr, int sum) {
        int[][] t = new int[arr.length+1][sum+1];

        for (int i=0; i<arr.length+1; i++) {
            for (int j=0; j<sum+1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i=1; i<arr.length+1; i++) {
            for (int j=1; j<sum+1; j++) {
                if (arr[i-1] <= j) {
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,8,10};
        int sum = 10;
        System.out.println(countOfSubsetSum(arr, sum));
    }
}
