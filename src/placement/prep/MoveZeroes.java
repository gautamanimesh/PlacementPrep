package placement.prep;

public class MoveZeroes {
    public static void moveZeroes (int[] arr) {
        int n = arr.length;
        int j = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }
        for (int element: arr) {
            System.out.print(element + " ");
        }
    }
    public static void main(String[] args) {
        int[] t = {8,1,0,2,1,0,3};
        moveZeroes(t);
    }
}
