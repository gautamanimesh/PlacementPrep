package placement.prep;

import java.util.ArrayList;
import java.util.List;

public class KthPermutation {

    private static String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            list.add(i);
        }
        list.add(n);
        k -= 1;
        String ans = "";
        while (true) {
            ans += list.get(k / fact);
            list.remove(k / fact);
            if (list.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / list.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        System.out.println(getPermutation(n, k));
    }
}
