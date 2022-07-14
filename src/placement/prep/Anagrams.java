package placement.prep;

import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "forgegeekesks";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        System.out.println(isAnagram(str1, str2));
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] arr = new int[26];
        Arrays.fill(arr,0);
        for (char ch: str1.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch: str2.toCharArray()) {
            arr[ch - 'a']--;
        }

        for (int j: arr) {
            if (j != 0) return false;
        }
        return true;
    }
}
