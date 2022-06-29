package placement.prep;

public class StringReversal {
    public static String reverseString (String input) {
        if (input.equals("")) return "";
        return reverseString(input.substring(1)) + input.charAt(0);
    }
    public static void main(String[] args) {
        String s = "kayak";
        String ans = reverseString(s);
        System.out.println(ans);
    }
}
