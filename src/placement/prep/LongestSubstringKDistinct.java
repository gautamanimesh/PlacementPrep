package placement.prep;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    private static int longestSubstringKDistinct (String str, int k) {
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while (map.size() > k) {
                char leftChar = str.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "AAAHHIBC";
        int k = 2;
        System.out.println(longestSubstringKDistinct(str, k));
    }
}
