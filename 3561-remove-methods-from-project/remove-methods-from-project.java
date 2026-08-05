import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] inv : invocations) {
            graph.get(inv[0]).add(inv[1]);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        for (int[] inv : invocations) {
            int caller = inv[0];
            int callee = inv[1];
            if (!suspicious[caller] && suspicious[callee]) {
                List<Integer> result = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    result.add(i);
                }
                return result;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] suspicious) {
        suspicious[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!suspicious[neighbor]) {
                dfs(neighbor, graph, suspicious);
            }
        }
    }
}