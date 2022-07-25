package placement.prep;

public class SubArraySum {

    private static int maxSubArraySum (int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (i >= (k - 1)) {
                max = Math.max(max, currSum);
                currSum -= arr[i - (k-1)];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int k = 3;
        System.out.println(maxSubArraySum(arr, k));
    }
}
