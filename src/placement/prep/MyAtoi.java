package placement.prep;

public class MyAtoi {

    private static int myAtoi (String str) {
        str = str.trim();
        if (str.length() == 0)
            return 0;

        int i = 0, flag = 1;
        long result = 0;

        if (str.charAt(0) == '-') {
            flag = -1;
            i = 1;
        } else if (str.charAt(0) == '+') {
            i = 1;
        }

        while (i < str.length()) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int digit = str.charAt(i) - '0';
                result = result * 10 + digit;
                if (result > Integer.MAX_VALUE) {
                    break;
                }
            }
            else {
                break;
            }
            i++;
        }

        if (result * flag > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result * flag < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result * flag;
    }

    public static void main(String[] args) {
        String str = "-000002147";
        System.out.println(myAtoi(str));

    }
}
