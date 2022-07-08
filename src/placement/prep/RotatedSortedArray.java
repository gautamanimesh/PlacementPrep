package placement.prep;

public class RotatedSortedArray {
    public static int findPivot (int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end-start) / 2;

            if (mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if (start < mid && arr[mid-1] > arr[mid]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
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
    public static int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        if (pivot == -1) {
            return binarySearch(arr,0,arr.length-1,target);
        }
        if (target == arr[pivot]) {
            return pivot;
        }
        if (target >= arr[0]) {
            return binarySearch(arr,0,pivot-1,target);
        }
        return binarySearch(arr,pivot+1,arr.length-1,target);
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,0,1,2,3,4};
        int target = 7;
        System.out.println(search(arr,target));
    }
}
