/* Topic: Graph
You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.
 */

import java.util.*;

class Solution31 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (var r : redEdges) adj.get(r[0]).add(new int[]{r[1], 0});
        for (var b : blueEdges) adj.get(b[0]).add(new int[]{b[1], 1});
        Set<String> visit = new HashSet<>();
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, -1, 0});
        while (!q.isEmpty()) {
            var a = q.poll();
            ans[a[0]] = Math.min(ans[a[0]], a[2]);
            for (var c : adj.get(a[0])) {
                String key = a[0] + "-" + c[0] + "-" + c[1];
                if (c[1] != a[1] && !visit.contains(key)) {
                    q.add(new int[]{c[0], c[1], a[2] + 1});
                    visit.add(key);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        return ans;
    }
}

public class Q31 {
    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        int[] ans = solution.shortestAlternatingPaths(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}}, new int[][]{});
        System.out.println(Arrays.toString(ans));
    }
}
