package placement.prep;

public class MinWindowSize {

    private static int minWindowSize (int[] arr, int input) {
        int minWindowSize = Integer.MAX_VALUE;
        int currSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currSum += arr[windowEnd];

            while (currSum >= input) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minWindowSize;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 7, 8, 1, 2, 8, 10};
        int input = 8;
        System.out.println(minWindowSize(arr, input));
    }
}
