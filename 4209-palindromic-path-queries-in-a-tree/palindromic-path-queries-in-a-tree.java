import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[] tin, tout, depth, parent, mask;
    int[][] up;
    int timer;
    Fenwick bit;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int LOG = 17;
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];
        up = new int[LOG][n];
        mask = new int[n];
        timer = 0;

        dfs(0, -1);

        bit = new Fenwick(2 * n + 2);

        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (s.charAt(i) - 'a');
            bit.update(tin[i], mask[i]);
            bit.update(tout[i], mask[i]);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                int newMask = 1 << (p[2].charAt(0) - 'a');
                int change = mask[u] ^ newMask;

                bit.update(tin[u], change);
                bit.update(tout[u], change);
                mask[u] = newMask;
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int l = lca(u, v);

                int pathMask = prefix(tin[u]) ^ prefix(tin[v]) ^ mask[l];
                ans.add(Integer.bitCount(pathMask) <= 1);
            }
        }

        return ans;
    }

    void dfs(int u, int p) {
        parent[u] = p == -1 ? u : p;
        up[0][u] = parent[u];

        for (int i = 1; i < up.length; i++)
            up[i][u] = up[i - 1][up[i - 1][u]];

        tin[u] = ++timer;

        for (int v : adj[u]) {
            if (v == p) continue;
            depth[v] = depth[u] + 1;
            dfs(v, u);
        }

        tout[u] = ++timer;
    }

    int prefix(int t) {
        return bit.query(t);
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }

        int diff = depth[u] - depth[v];

        for (int i = 0; i < up.length; i++)
            if ((diff & (1 << i)) != 0)
                u = up[i][u];

        if (u == v) return u;

        for (int i = up.length - 1; i >= 0; i--) {
            if (up[i][u] != up[i][v]) {
                u = up[i][u];
                v = up[i][v];
            }
        }

        return parent[u];
    }

    class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int i, int val) {
            for (; i <= n; i += i & -i)
                tree[i] ^= val;
        }

        int query(int i) {
            int res = 0;
            for (; i > 0; i -= i & -i)
                res ^= tree[i];
            return res;
        }
    }
}