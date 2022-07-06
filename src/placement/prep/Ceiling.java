package placement.prep;

public class Ceiling {

    // Ceiling: Smallest number that is greater than or equal to target!
    public static int ceiling (int[] arr, int l, int r, int target) {
        if (target > arr[arr.length-1]) return -1;
        if (r >= l) {
            int mid = (l+r)/2;
            if (arr[mid] == target) {
                return arr[mid];
            }
            if (arr[mid] > target) {
                return ceiling(arr,l,mid-1,target);
            }
            return ceiling(arr,mid+1,r,target);
        }
        return arr[l];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 14;
        System.out.println(ceiling(arr,0,arr.length-1,target));
    }
}
