package placement.prep;

public class Floor {

    // Floor: Greatest number that is smaller than or equal to target!
    public static int floor (int[] arr, int low, int high, int target) {
        if (target < arr[0]) return -1;
        if (high >= low) {
            int mid = low + (high - low) /2;
            if (arr[mid] == target) {
                return arr[mid];
            }
            if (arr[mid] > target) {
                return floor(arr, low, mid-1, target);
            }
            return floor(arr, mid+1, high, target);
        }
        return arr[high];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        System.out.println(floor(arr,0,arr.length-1,target));
    }
}
