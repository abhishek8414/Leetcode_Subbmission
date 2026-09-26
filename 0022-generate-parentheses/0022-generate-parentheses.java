import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {
        int count = catalan(n);
        List<String> ans = new ArrayList<>(count);

        char[] path = new char[2 * n];
        dfs(ans, path, 0, 0, n);

        return ans;
    }

    private void dfs(List<String> ans, char[] path,
                     int pos, int open, int n) {

        if (pos == path.length) {
            ans.add(new String(path));
            return;
        }

        if (open < n) {
            path[pos] = '(';
            dfs(ans, path, pos + 1, open + 1, n);
        }

        int close = pos - open;

        if (close < open) {
            path[pos] = ')';
            dfs(ans, path, pos + 1, open, n);
        }
    }

    private int catalan(int n) {
        long c = 1;

        for (int i = 0; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) c;
    }
}