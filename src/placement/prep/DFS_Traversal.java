package placement.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS_Traversal {

    /*
     * Time Complexity: O(N+E)
     * Space Complexity: O(N+E) + O(N) + O(N)
     */

    private static List<Integer> dfs (int[][] edges, int n) {
        List<Integer> ans = new ArrayList<>();

        boolean[] vis = new boolean[n+1];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfsUtil(i, vis, map, ans);
            }
        }

        return ans;
    }

    private static void dfsUtil(int node, boolean[] vis, HashMap<Integer, ArrayList<Integer>> map, List<Integer> ans) {
        ans.add(node);
        vis[node] = true;

        for (Integer it: map.get(node)) {
            if (!vis[it]) {
                dfsUtil(it, vis, map, ans);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {2, 4},
                {2, 7},
                {3, 5},
                {4, 6},
                {6, 7},
        };
        int n = 7;
        List<Integer> res = dfs(edges, n);
        System.out.println(res);
    }
}
