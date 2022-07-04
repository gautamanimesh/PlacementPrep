package placement.prep;

public class EqualSumPartition {

    public static boolean equalSum (int[] arr, int sum) {
        boolean[][] t = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i=1; i<arr.length+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                }
                else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int sum = 0;
        for (int element: arr) {
            sum += element;
        }
        if (sum % 2 == 0) {
            System.out.println(equalSum(arr,sum/2));
        } else {
            System.out.println(false);
        }
    }
}
