package placement.prep;

public class MoveAllX {

    public static void moveAllX (String str, int idx, int count, String newStr) {
        if (idx == str.length()) {
            while (count-- > 0) {
                newStr += 'x';
            }
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (currChar == 'x') {
            count++;
            moveAllX(str, idx+1, count, newStr);
        } else {
            newStr += currChar;
            moveAllX(str, idx+1, count, newStr);
        }
    }

    public static void main(String[] args) {
        String str = "abxcxxd";
        moveAllX(str, 0, 0,"");
    }
}
