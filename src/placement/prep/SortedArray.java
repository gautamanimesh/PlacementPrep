package placement.prep;

public class SortedArray {

    public static boolean isSorted (int[] arr, int idx) {
        if (idx == arr.length-1) {
            return true;
        }

        if (arr[idx] >= arr[idx+1]) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(isSorted(arr,0));
    }
}
