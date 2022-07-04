package placement.prep;

public class FindMissingNumber {

    public static int missingNumber (int[] arr, int range) {
        int n = arr.length;
        int sumOfN = range * (range+1) / 2;
        int sum = 0;
        for (int j: arr) {
            sum += j;
        }
        return sumOfN - sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,10};
        int range = 10;
        System.out.println(missingNumber(arr,range));
    }
}
