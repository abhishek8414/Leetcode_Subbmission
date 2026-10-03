class Solution {
    public boolean isPalindrome(int x) {

        // Negative number is never palindrome
        if (x < 0) {
            return false;
        }

        // 0 is palindrome
        if (x == 0) {
            return true;
        }

        int original = x;
        int reverse = 0;

        while (x > 0) {
            int digit = x % 10;

            reverse = reverse * 10 + digit;

            x = x / 10;
        }

        return original == reverse;
    }
}