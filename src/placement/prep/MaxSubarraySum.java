package placement.prep;

public class MaxSubarraySum {

    public static int maxSubarraySum (int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            int currSum = 0;
            for (int j=i; j<n; j++) {
                currSum += arr[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5}; // {-1,-2,-3,-4}
        System.out.println(maxSubarraySum(arr));
    }
}
