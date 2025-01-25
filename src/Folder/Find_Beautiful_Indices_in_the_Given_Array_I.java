public class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        // List to store the beautiful indices
        List<Integer> ans = new ArrayList<>();
        // Lists to store starting indices of occurrences of strings 'a' and 'b'
        List<Integer> indices_a = new ArrayList<>();
        List<Integer> indices_b = new ArrayList<>();

        // Step 2: Find indices of occurrences of string 'a'
        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                indices_a.add(i);
            }
        }

        // Step 3: Find indices of occurrences of string 'b'
        for (int j = 0; j <= s.length() - b.length(); j++) {
            if (s.substring(j, j + b.length()).equals(b)) {
                indices_b.add(j);
            }
        }

        // Step 4: Check conditions and add beautiful indices to 'ans'
        for (int i : indices_a) {
            for (int j : indices_b) {
                // Check if substrings match and absolute difference <= k
                if (Math.abs(i - j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }

        // Step 5: Sort the beautiful indices in ascending order
        ans.sort(null);

        // Step 6: Return the final result
        return ans;
    }
}