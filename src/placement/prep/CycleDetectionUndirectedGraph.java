package placement.prep;

import java.util.ArrayList;
import java.util.HashMap;

public class CycleDetectionUndirectedGraph {

    private static String cycleDetection (int[][] edges, int n, int m) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int j = 0; j < m; j++) {
            adj.get(edges[j][0]).add(edges[j][1]);
            adj.get(edges[j][1]).add(edges[j][0]);
        }
        boolean[] isVis = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            if (!isVis[i]) {
                if (isCycle(i, -1, adj, isVis)) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    private static boolean isCycle(int node, int par, HashMap<Integer, ArrayList<Integer>> adj, boolean[] isVis) {
        isVis[node] = true;
        for (int it: adj.get(node)) {
            if (!isVis[it]) {
                //isVis[it] = true;
                if (isCycle(it, node, adj, isVis)) {
                    return true;
                }
            } else if (par != it) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {5,1}
        };

        int n = 5;
        int m = 5;
        System.out.println(cycleDetection(edges,n,m));
    }
}
