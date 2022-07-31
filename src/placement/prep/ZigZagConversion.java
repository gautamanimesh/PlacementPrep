package placement.prep;

public class ZigZagConversion {

    private static String convert(String str, int nRows) {
        String[] helper = new String[nRows];
        for (int i = 0; i < nRows; i++) {
            helper[i] = "";
        }
        int row = 0, delta = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            helper[row] += c;
            if (row == nRows - 1) {
                delta = -1;
            } else if (row == 0) {
                delta = 1;
            }
            row = row + delta;
            row = Math.max(0, row);
        }
        String result = "";
        for (int i = 0; i < nRows && str.length() > 0; i++) {
            result += helper[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "PQRSTUVWXYZ";
        int nRows = 3;
        System.out.println(convert(str, nRows));
    }
}
