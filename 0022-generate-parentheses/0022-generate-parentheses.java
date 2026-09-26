import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[2 * n];

        backtrack(ans, path, 0, 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans, char[] path,
                           int index, int open, int close, int n) {

        // Complete valid combination
        if (index == 2 * n) {
            ans.add(new String(path));
            return;
        }

        // Add '('
        if (open < n) {
            path[index] = '(';
            backtrack(ans, path, index + 1, open + 1, close, n);
        }

        // Add ')'
        if (close < open) {
            path[index] = ')';
            backtrack(ans, path, index + 1, open, close + 1, n);
        }
    }
}