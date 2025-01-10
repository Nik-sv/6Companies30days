class Solution{
    // Method to display contacts based on the given prefix
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // Create the root trie node
        trie root = new trie();
        // Build the trie using the contact strings
        build(contact, root);
        // Create an ArrayList to store result
        ArrayList<ArrayList<String>> A = new ArrayList<>();
        // Iterate through the prefix string
        for (int i = 1; i <= s.length(); i++) {
            // Create an ArrayList to store contacts with matching prefix
            ArrayList<String> ar = new ArrayList<>();
            // Find contacts with matching prefix in the trie and store them in ar
            find(s.substring(0, i), root, ar, contact);
            // Sort the contacts in ar
            Collections.sort(ar);
            // Add ar to the result ArrayList
            A.add(ar);
        }
        // Return the result
        return A;
    }

    // Method to build the trie using the contact strings
    public static void build(String a[], trie root) {
        // Create a temp trie node
        trie temp = null;
        // Iterate through the contact strings
        for (int i = 0; i < a.length; i++) {
            // Set temp as root for each contact string
            temp = root;
            // Iterate through each character in the contact string
            for (int j = 0; j < a[i].length(); j++) {
                // Check if the character node is null in the trie, if so, then create a new trie node
                if (temp.ch[a[i].charAt(j) - 'a'] == null)
                    temp.ch[a[i].charAt(j) - 'a'] = new trie();
                // Move to the next character node in the trie
                temp = temp.ch[a[i].charAt(j) - 'a'];
                // Add the contact string to the node's HashSet
                temp.arr.add(a[i]);
            }
        }
    }

    // Method to find contacts with matching prefix in the trie
    public static void find(String s, trie root, ArrayList<String> ar, String contact[]) {
        // Initialize a flag to check if any character is missing in the trie
        int q = 0;
        // Iterate through the prefix string
        for (int i = 0; i < s.length(); i++) {
            // Check if the character node is null in the trie, if so, then set the flag as 1 and break
            if (root.ch[s.charAt(i) - 'a'] == null) {
                q = 1;
                break;
            }
            // Move to the next character node in the trie
            root = root.ch[s.charAt(i) - 'a'];
        }
        // If flag is 1, no contact found with matching prefix, add "0" to ar
        if (q == 1) {
            ar.add("0");
        } else {
            // Iterate through the HashSet of the last character node in the trie and add found contacts to ar
            for (String i : root.arr) {
                ar.add(i);
            }
        }
    }

    // Class representing trie node
    public static class trie {
        HashSet<String> arr; // HashSet to store contacts at the node
        trie ch[]; // Array of trie nodes representing characters
        public trie() {
            arr = new HashSet<>(); // Initialize the HashSet
            ch = new trie[26]; // Initialize the character array with size 26
            for (int i = 0; i < 26; i++) {
                ch[i] = null; // Set each character node as null
            }
        }
    }
}