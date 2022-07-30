package placement.prep;

public class PalindromeNumber {

    private static boolean isPalindrome(int num) {
        if (num < 0) return false;

        int left = 1;
        while (num / left >= 10) {
            left = left * 10;
        }
        int right = 1;
        while (left > right) {
            if ((num / left) % 10 != (num / right) % 10) {
                return false;
            }
            left = left / 10;
            right = right * 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 101;
        System.out.println(isPalindrome(num));
    }
}
