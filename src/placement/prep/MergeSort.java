package placement.prep;

public class MergeSort {

    /*
     * Time Complexity: Worst case: O(nlog(n))
     */

    public static void mergeSort (int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    public static void merge (int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = data[i++];
        }

        while (j <= end) {
            temp[k++] = data[j++];
        }

        for (i = start; i<= end; i++) {
            data[i] = temp[i - start];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-5,0,2,3,10,20};
        mergeSort(arr,0,arr.length - 1);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }
}
