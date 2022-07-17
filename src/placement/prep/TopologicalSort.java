package placement.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    /*
    * Can be applied to DAGs only! :: DAG: Directed-Acyclic Graphs.
    * Linear ordering of vertices such that if there is an edge u->v then u appears
      before v in that ordering.
    * Kahn's Algorithm
    * Time Complexity: O(N+E) :: N = # of vertices, E = # of edges
    * Space Complexity: O(N) + O(N) + O(N)
    */
    private static int[] topoSort_BFS(int n, HashMap<Integer, ArrayList<Integer>> adj) {
        // This is BFS implementation.
        int[] topo = new int[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (Integer it: adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int ind = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            topo[ind++] = node;

            for (Integer it: adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
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
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = 4;
        int m = edges.length;
        for (int i = 0; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int j = 0; j < m; j++) {
            adj.get(edges[j][0]).add(edges[j][1]);
        }

        int[] ans = topoSort_BFS(n, adj);
        for (Integer element: ans) {
            System.out.print(element + " ");
        }
    }
}
