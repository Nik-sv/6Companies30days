class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;

        // Helper function to calculate the length of a palindromic subsequence
        int[] palinLength = new int[1 << n]; // Store lengths of palindromic subsequences
        for (int mask = 0; mask < (1 << n); mask++) {
            if (isPalindrome(s, mask)) {
                palinLength[mask] = Integer.bitCount(mask);
            }
        }

        // Iterate through all pairs of masks to find disjoint palindromic subsequences
        for (int mask1 = 0; mask1 < (1 << n); mask1++) {
            for (int mask2 = 0; mask2 < (1 << n); mask2++) {
                if ((mask1 & mask2) == 0) { // Disjoint subsequences
                    maxProduct = Math.max(maxProduct, palinLength[mask1] * palinLength[mask2]);
                }
            }
        }

        return maxProduct;
    }

    // Helper function to check if a subsequence is a palindrome
    private boolean isPalindrome(String s, int mask) {
        int left = 0, right = s.length() - 1;
        StringBuilder subseq = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if ((mask & (1 << i)) != 0) {
                subseq.append(s.charAt(i));
            }
        }

        String str = subseq.toString();
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
