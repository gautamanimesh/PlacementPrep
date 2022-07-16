package placement.prep;

public class Sort012 {

    public static void sort012(int[] arr)
    {
        //Write your code here
        int start = 0, end = arr.length-1, mid = 0, temp;
        while (mid <= end) {
            switch(arr[mid]) {
                case 0:
                    temp = arr[start];
                    arr[start] = arr[mid];
                    arr[mid] = temp;
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[end];
                    arr[end] = arr[mid];
                    arr[mid] = temp;
                    end--;
                    break;
            }
        }

        for (int j: arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,1,0};
        for (int j: arr) {
            System.out.print(j + " ");
        }
        System.out.println();
        sort012(arr);
    }
}
