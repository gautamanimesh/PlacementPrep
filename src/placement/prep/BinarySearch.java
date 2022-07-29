package placement.prep;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                return binarySearch(arr, low, mid-1, target);
            }
            return binarySearch(arr, mid+1, high, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int target = scanner.nextInt();
        int ans = binarySearch(nums, 0, nums.length-1, target);
        System.out.println(ans);
    }
}
