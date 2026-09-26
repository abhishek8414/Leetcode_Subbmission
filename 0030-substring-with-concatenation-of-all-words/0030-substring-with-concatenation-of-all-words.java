import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (totalLen > s.length()) {
            return ans;
        }

        // Required frequency of each word
        Map<String, Integer> target = new HashMap<>();

        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }

        // Try every possible alignment
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int right = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // Word is not present in words
                if (!target.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                // Add word to current window
                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                // Too many occurrences of this word
                while (window.get(word) > target.get(word)) {

                    String leftWord = s.substring(left, left + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }

                // Found exactly wordCount words
                if (count == wordCount) {

                    ans.add(left);

                    // Move left to search for overlapping answers
                    String leftWord = s.substring(left, left + wordLen);

                    window.put(leftWord, window.get(leftWord) - 1);

                    left += wordLen;
                    count--;
                }
            }
        }

        return ans;
    }
}