package placement.prep;

import java.util.HashSet;

public class SubsequenceOfAString {

    public static void subsequencesOfAString (String str, int idx, String newString, HashSet<String> set) { // unique
        if (idx == str.length()) {
            if (!set.contains(newString)) {
                System.out.println(newString);
                set.add(newString);
            }
            return;
        }
        char currChar = str.charAt(idx);
        //to be
        subsequencesOfAString(str, idx+1, newString+currChar, set);
        //not to be
        subsequencesOfAString(str, idx+1, newString, set);
    }

    public static void main(String[] args) {
        String str = "111";
        HashSet<String> set = new HashSet<>();
        subsequencesOfAString(str, 0, "", set);
    }
}
