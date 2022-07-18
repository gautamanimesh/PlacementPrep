package placement.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BipartiteGraph {
    /*
    * Bipartite Graph: A graph that can be colored using two colors such that no two
      adjacent nodes have the same color.
    * All graphs except any graph having an odd length cycle are bipartite graphs.
    * Time Complexity: O(N + E)
    * Space Complexity: O(N+E) + O(N)
    * Auxiliary Space: O(N)
    * DFS implementation.
    */
    private static boolean isBipartite (int n, int[][] edges) {
        int[] color = new int[n];
        Arrays.fill(color, -1);

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!checkBipartite(i, map, color)) return false;
            }
        }
        return true;
    }

    private static boolean checkBipartite (int node, HashMap<Integer, ArrayList<Integer>> adj, int[] color) {
        if (color[node] == -1) color[node] = 1;

        for (Integer it: adj.get(node)) {
            if (color[it] == -1) {
                color[it] = 1 - color[node];

                if (!checkBipartite(it, adj, color))
                    return false;
            }
            else if (color[it] == color[node])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {1,2},
                {2,3},
                {4,3},
                {4,5},
                {4,6},
                {1,6}
        };
        int n = 7;
        System.out.println(isBipartite(n, edges));
    }
}
