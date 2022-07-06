package placement.prep;

public class InfiniteArray {
    // Leetcode
    public static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int temp = end+1;
            end = end + (end - start + 1);
            start = temp;
        }
        return binarySearch(arr,start,end,target);
    }

    public static int binarySearch(int[] arr, int l, int r, int target) {
        if (r >= l) {
            int mid = (l+r)/2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                return binarySearch(arr,l,mid-1,target);
            }
            return binarySearch(arr,mid+1,r,target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10,90,100,130,140,160,170};
        int target = 10;
        System.out.println(ans(arr,target));
    }
}
