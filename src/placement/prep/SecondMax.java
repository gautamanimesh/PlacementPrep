package placement.prep;

public class SecondMax {

    public static int secondMax (int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j != max) {
                secondMax = j;
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int[] t = {33,43,45,12,13,14};
        System.out.println(secondMax(t));
    }
}
