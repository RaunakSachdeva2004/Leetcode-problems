class Solution {
    private char[] sArr;
    private int n;
    private Node[] tree;

    private static class Node {
        int maxLen;
        int prefixLen;
        int suffixLen;
        char leftChar;
        char rightChar;

        public Node(int maxLen, int prefixLen, int suffixLen, char leftChar, char rightChar) {
            this.maxLen = maxLen;
            this.prefixLen = prefixLen;
            this.suffixLen = suffixLen;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        sArr = s.toCharArray();
        n = sArr.length;
        tree = new Node[4 * n];
        build(0, 0, n - 1);

        int k = queryCharacters.length();
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int index = queryIndices[i];
            char updateChar = queryCharacters.charAt(i);
            sArr[index] = updateChar;
            update(0, 0, n - 1, index, updateChar);
            result[i] = tree[0].maxLen;
        }

        return result;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            char c = sArr[start];
            tree[node] = new Node(1, 1, 1, c, c);
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);
        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2], start, mid, end);
    }

    private void update(int node, int start, int end, int idx, char val) {
        if (start == end) {
            tree[node] = new Node(1, 1, 1, val, val);
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, val);
        } else {
            update(2 * node + 2, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2], start, mid, end);
    }

    private Node merge(Node left, Node right, int start, int mid, int end) {
        int leftLen = mid - start + 1;
        int rightLen = end - mid;

        int maxLen = Math.max(left.maxLen, right.maxLen);
        char leftChar = left.leftChar;
        char rightChar = right.rightChar;

        if (left.rightChar == right.leftChar) {
            int combinedLen = left.suffixLen + right.prefixLen;
            maxLen = Math.max(maxLen, combinedLen);
        }

        int prefixLen = left.prefixLen;
        if (left.prefixLen == leftLen && left.rightChar == right.leftChar) {
            prefixLen += right.prefixLen;
        }

        int suffixLen = right.suffixLen;
        if (right.suffixLen == rightLen && left.rightChar == right.leftChar) {
            suffixLen += left.suffixLen;
        }

        return new Node(maxLen, prefixLen, suffixLen, leftChar, rightChar);
    }
}