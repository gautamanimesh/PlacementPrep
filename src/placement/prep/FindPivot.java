package placement.prep;

public class FindPivot {

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

    public static int findPivotWithDuplicates (int[] arr) {
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
            // if elements in the middle, start and end are equal, then just skip the duplicates!
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip duplicates!
                // NOTE: check for pivot first!
                // check whether start is pivot?
                if (arr[start] > arr[start+1]) {
                    return start;
                }
                start++;
                // check whether end is pivot?
                if (arr[end] < arr[end-1]) {
                    return end-1;
                }
                end--;
            // left side is sorted, so pivot should be on the right side!
            } else if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {5,6,7,0,1,2,3,4};
        int[] arr2 = {2,9,2,2,2,2};
        System.out.println(findPivot(arr));
        System.out.println(findPivotWithDuplicates(arr2));
    }
}
