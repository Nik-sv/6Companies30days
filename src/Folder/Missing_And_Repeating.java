class Solution {
    // Function to find two elements in the array
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        // Initialize variables to store the sum and square sum differences
        long S = (long)n * (n + 1) / 2; // Sum of first n natural numbers
        long P = (long)n * (n + 1) * (2 * n + 1) / 6; // Sum of squares of first n numbers

        long actualSum = 0, actualSquareSum = 0;

        // Calculate the sum and square sum of array elements
        for (int num : arr) {
            actualSum += num;
            actualSquareSum += (long)num * num;
        }

        // Calculate differences
        long diffSum = S - actualSum; // a - b
        long diffSquareSum = P - actualSquareSum; // a^2 - b^2

        // From (a^2 - b^2) = (a - b)(a + b), calculate a + b
        long sum = diffSquareSum / diffSum;

        // Calculate a and b
        int missing = (int)((diffSum + sum) / 2);
        int repeating = (int)(sum - missing);

        // Add results to the list
        result.add(repeating);
        result.add(missing);

        return result;
    }
}
