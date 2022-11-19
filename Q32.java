import java.util.*;

class Solution32 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) return source == destination;
        List<Integer>[] graph = new ArrayList[n];
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            if (graph[v] == null) {
                graph[v] = new ArrayList<>();
            }
            graph[v].add(w);
            if (graph[w] == null) {
                graph[w] = new ArrayList<>();
            }
            graph[w].add(v);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : graph[curr]) {
                if (neighbor == destination) return true;

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
}

public class Q32 {
    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        boolean path = solution.validPath(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}}, 0, 2);
        System.out.println(path);
    }
}
