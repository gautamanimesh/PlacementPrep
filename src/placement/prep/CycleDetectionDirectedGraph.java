package placement.prep;

import java.util.ArrayList;
import java.util.HashMap;

public class CycleDetectionDirectedGraph {

    private static boolean cycleDetection(int n, int[][] edges) {
        int[] vis = new int[n+1];
        int[] dfsVis = new int[n+1];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
        }

        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                if (isCycle (i, map, vis, dfsVis)) return true;
            }
        }
        return false;

    }

    private static boolean isCycle (int node, HashMap<Integer, ArrayList<Integer>> adj, int[] vis, int[] dfsVis) {
        vis[node] = 1;
        dfsVis[node] = 1;

        for (Integer it: adj.get(node)) {
            if (vis[it] == 0) {
                if (isCycle(it, adj, vis, dfsVis)) return true;
            } else if (dfsVis[it] == 1) return true;
        }
        dfsVis[node] = 0;
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1,2},
                {4,1},
                {2,4},
                {3,4},
                {5,2},
                {1,3}
        };

        int n = 5;
        System.out.println(cycleDetection(n, edges));
    }
}
