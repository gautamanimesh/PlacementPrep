package placement.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class TopologicalSort_DFS {
    /*
    * Can be applied to DAGs only! :: DAG: Directed-Acyclic Graphs.
    * Linear ordering of vertices such that if there is an edge u->v then u appears
      before v in that ordering.
    * Kahn's Algorithm
    * Time Complexity: O(N+E) :: N = # of vertices, E = # of edges
    * Space Complexity: O(N) + O(N) + O(N)
    * Auxiliary Space Complexity: O(N)
    */
    private static void topoDFS (int node, HashMap<Integer, ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;

        for (Integer it: adj.get(node)) {
            if (vis[it] == 0) {
                topoDFS(it, adj, vis, stack);
            }
        }
        stack.push(node);
    }

    private static int[] topoSort_DFS (int n, int[][] edges) {
        // This is DFS implementation.
        int[] vis = new int[n];
        Stack<Integer> stack = new Stack<>();

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                topoDFS(i, map, vis, stack);
            }
        }

        int[] topo = new int[n];
        int ind = 0;

        while (!stack.isEmpty()) {
            topo[ind++] = stack.pop();
        }

        return topo;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {0,3},
                {1,2},
                {3,2}
        };
        int n = 4;
        int[] ans = topoSort_DFS(n, edges);
        System.out.println(Arrays.toString(ans));
    }
}
