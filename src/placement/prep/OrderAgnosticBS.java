package placement.prep;

public class OrderAgnosticBS {

    public static int orderAgnosticBS (int[] arr, int start, int end, int target) {
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end-start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,7,5,3,1};
        int target = 5;
        System.out.println(orderAgnosticBS(arr,0,arr.length-1,target));
    }
}
