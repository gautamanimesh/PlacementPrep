package placement.prep;

public class SumOfNaturalNumbers {
    public static int findSum (int inputNumber) {
        if (inputNumber <= 1) {
            return inputNumber;
        }
        return inputNumber + findSum(inputNumber-1);
    }
    public static void main(String[] args) {
        int num = 10;
        int ans = findSum(num);
        System.out.println(ans);
    }
}
