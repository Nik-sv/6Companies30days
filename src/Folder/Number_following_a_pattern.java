class Solution {
    static String printMinNumberForPattern(String S) {
        // Result to store the minimum number
        StringBuilder result = new StringBuilder();

        // Stack to store numbers
        Stack<Integer> stack = new Stack<>();

        // Initialize a number to push into the stack
        int number = 1;

        for (char ch : S.toCharArray()) {
            // Push the current number into the stack
            stack.push(number++);

            // If the character is 'I', pop the stack and append to result
            if (ch == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        // Push the last number into the stack
        stack.push(number);

        // Pop any remaining numbers in the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
