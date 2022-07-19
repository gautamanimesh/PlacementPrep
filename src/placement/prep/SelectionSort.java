package placement.prep;

import java.util.Arrays;

public class SelectionSort {

    private static void selectionSort (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;

            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    private static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int getMaxIndex (int[] arr, int start, int end) {
        int max = start;

        for (int i = 0; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
