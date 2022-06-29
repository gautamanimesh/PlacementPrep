package placement.prep;


public class DecimalToBinary {
    public static String findBinary (int decimal, String string) {
        if (decimal == 0) {
            return string;
        }
        string = decimal % 2 + string;
        return findBinary(decimal / 2, string);
    }
    public static void main(String[] args) {
        int decimal = 10;
        String binary = findBinary(decimal, "");
        System.out.println(binary);
    }
}
