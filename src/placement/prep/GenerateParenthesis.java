package placement.prep;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {

    private static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        process("", 0, 0, result, n);
        return result;
    }

    private static void process(String prefix, int open, int close, List<String> result, int max) {
        if (prefix.length() == max * 2) {
            result.add(prefix);
            return;
        }

        if (open < max) process(prefix + '(', open + 1, close, result, max);
        if (close < open) process(prefix + ')', open, close + 1, result, max);
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans.toString());
    }
}
