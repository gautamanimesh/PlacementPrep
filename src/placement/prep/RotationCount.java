package placement.prep;

public class RotationCount {

    public static int rotationsCount (int[] arr) {
        int pivot = findPivot(arr);
        return pivot+1;
    }

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

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,0,1,2};
        System.out.println(rotationsCount(arr));
    }

}
