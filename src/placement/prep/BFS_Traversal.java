package placement.prep;

import java.util.*;

public class BFS_Traversal {

    /*
     * Time Complexity: O(N+E)
     * Space Complexity: O(N+E) + O(N) + O(N)
     */
    private static List<Integer> bfs (int[][] edges, int n) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n+1];

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                vis[i] = true;

                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    ans.add(node);

                    for (Integer it: map.get(node)) {
                        if (!vis[it]) {
                            vis[it] = true;
                            queue.add(it);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {2, 3},
                {2, 7},
                {3, 5},
                {4, 6},
                {5, 7},
        };
        int n = 7;
        List<Integer> res = bfs(edges, n);
        System.out.println(res);
    }
}
