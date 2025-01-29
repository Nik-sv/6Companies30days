class Solution {
    public static String encode(String s) {
        StringBuilder encoded = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            encoded.append(s.charAt(i)).append(count);
        }

        return encoded.toString();
    }
}