package placement.prep;

import java.util.Arrays;

public class MinSumDigitsOfArray {

    private static int sum (int[] arr, int n) {

        Arrays.sort(arr); // {0,3,4,5,7};

        int a = 0;
        int b = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                a = a*10 + arr[i]; // 3, 35
            } else {
                b = b*10 + arr[i]; // 0, 4, 47
            }
        }

        return a+b;
    }

    public static void main(String[] args) {
        int[] arr = {5,3,0,7,4};
        int n = 5;
        System.out.println(sum(arr,n));
    }
}
