package placement.prep;

import java.util.Arrays;

public class FirstAndLastIndex {
    // Leetcode
    public static int[] firstAndLastIndex (int[] arr, int target) {
        int[] ans = {-1,-1};

        ans[0] = firstAndLastIndexHelper(arr,target,true);
        if (ans[0] != -1) {
            ans[1] = firstAndLastIndexHelper(arr,target,false);
        }

        return ans;
    }

    public static int firstAndLastIndexHelper (int[] arr, int target, boolean firstIndex) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end-start) / 2;

            if (target < arr[mid]) {
                end = mid-1;
            } else if (target > arr[mid]) {
                start = mid+1;
            } else {
                ans = mid;
                if (firstIndex) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,7,7,8,8,10};
        int target = 7;
        System.out.println(Arrays.toString(firstAndLastIndex(arr, target)));
    }
}
