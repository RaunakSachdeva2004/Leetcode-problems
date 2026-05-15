import java.util.*;

class Solution {

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean isConcatenated(String word, Set<String> st) {

        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        int l = word.length();

        for (int i = 0; i < l; i++) {

            String prefix = word.substring(0, i + 1);
            String suffix = word.substring(i + 1);

            if (st.contains(prefix)) {

                if (st.contains(suffix) || isConcatenated(suffix, st)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }

        memo.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Set<String> st = new HashSet<>(Arrays.asList(words));

        List<String> res = new ArrayList<>();

        for (String word : words) {

            if (word.length() == 0) {
                continue;
            }

            if (isConcatenated(word, st)) {
                res.add(word);
            }
        }

        return res;
    }
}