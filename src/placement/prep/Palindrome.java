package placement.prep;

public class Palindrome {
    public static boolean isPalindrome (String string) {
        if (string.length() == 0 || string.length() == 1) {
            return true;
        }
        if (string.charAt(0) == string.charAt(string.length()-1)) {
            return isPalindrome(string.substring(1,string.length()-1));
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "kayak";
        boolean ans = isPalindrome(s);
        System.out.println(ans);
    }
}
