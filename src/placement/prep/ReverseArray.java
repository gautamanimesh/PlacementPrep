package placement.prep;

public class ReverseArray {

    public static void reverseArray (int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n-1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        for (int j: arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverseArray(t);
    }
}
