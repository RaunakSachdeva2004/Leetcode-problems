import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[] last;
    int[] ans;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        adj = new ArrayList[n];
        last = new int[26];
        ans = new int[n];

        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        dfs(0, s, newParent);

        for (int i = 0; i < n; i++) {
            adj[i].clear();
        }

        for (int i = 1; i < n; i++) {
            adj[newParent[i]].add(i);
        }

        calculate(0);

        return ans;
    }

    void dfs(int node, String s, int[] newParent) {
        int c = s.charAt(node) - 'a';
        int old = last[c];

        if (old != -1) {
            newParent[node] = old;
        }

        last[c] = node;

        for (int child : adj[node]) {
            dfs(child, s, newParent);
        }

        last[c] = old;
    }

    int calculate(int node) {
        int size = 1;

        for (int child : adj[node]) {
            size += calculate(child);
        }

        ans[node] = size;
        return size;
    }
}