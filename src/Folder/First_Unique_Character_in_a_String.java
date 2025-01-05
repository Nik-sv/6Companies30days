class Solution {
    public int firstUniqChar(String s) {

        int n = s.length();

        // Step 1: Traverse through the string using an outer Loop
        for(int i = 0; i < n; i++) {
            boolean isUnique = true;

            // Step 2: Check if the current character is unique using an inner loop

            for (int j = 0; j < n; j++) {
                if (i != j && s.charAt(i) == s.charAt(j))  {
                    isUnique = false;
                    break;
                }
            }

            // Step 3: If the character is unique , return its index
            if(isUnique) {
                return i;
            }
        }

        // Step 4: If no unique character found, return -1
        return -1;

    }
}