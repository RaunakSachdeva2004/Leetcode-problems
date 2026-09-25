import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> ans = dfs(expression, 0, expression.length());
        List<String> res = new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }

    Set<String> dfs(String s, int l, int r) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        int i = l;

        while (i < r) {
            char ch = s.charAt(i);

            if (ch == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;
            }

            else if (ch == '{') {
                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '{') count++;
                    else if (s.charAt(j) == '}') count--;
                    j++;
                }

                Set<String> inside = dfs(s, i + 1, j - 1);

                Set<String> temp = new HashSet<>();

                for (String a : current) {
                    for (String b : inside) {
                        temp.add(a + b);
                    }
                }

                current = temp;
                i = j;
            }

            else {
                Set<String> temp = new HashSet<>();

                for (String x : current) {
                    temp.add(x + ch);
                }

                current = temp;
                i++;
            }
        }

        result.addAll(current);
        return result;
    }
}