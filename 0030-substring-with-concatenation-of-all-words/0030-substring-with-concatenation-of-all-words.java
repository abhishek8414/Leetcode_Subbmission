import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (totalLen > s.length()) return result;

        Map<String, Integer> need = new HashMap<>();

        for (String word : words) {
            need.merge(word, 1, Integer::sum);
        }

        for (int start = 0; start < wordLen; start++) {

            int left = start;
            int right = start;
            int count = 0;

            Map<String, Integer> have = new HashMap<>();

            while (right + wordLen <= s.length()) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

                Integer required = need.get(word);

                // Invalid word
                if (required == null) {
                    have.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                int current = have.getOrDefault(word, 0) + 1;
                have.put(word, current);
                count++;

                // Too many occurrences
                while (current > required) {

                    String leftWord = s.substring(left, left + wordLen);

                    int newCount = have.get(leftWord) - 1;

                    if (newCount == 0) {
                        have.remove(leftWord);
                    } else {
                        have.put(leftWord, newCount);
                    }

                    left += wordLen;
                    count--;

                    if (leftWord.equals(word)) {
                        current = newCount;
                    }
                }

                // Found valid concatenation
                if (count == wordCount) {

                    result.add(left);

                    String leftWord = s.substring(left, left + wordLen);

                    int newCount = have.get(leftWord) - 1;

                    if (newCount == 0) {
                        have.remove(leftWord);
                    } else {
                        have.put(leftWord, newCount);
                    }

                    left += wordLen;
                    count--;
                }
            }
        }

        return result;
    }
}
