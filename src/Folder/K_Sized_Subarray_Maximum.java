class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Create a deque (double-ended queue) to store indices
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Process the first k elements
        for (int i = 0; i < k; i++) {
            // Remove indices of smaller elements from the rear
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            // Add the current index to the rear
            dq.addLast(i);
        }

        // Process the remaining elements
        for (int i = k; i < arr.length; i++) {
            // Add the maximum element of the current window to the result
            result.add(arr[dq.peekFirst()]);

            // Remove indices of elements that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.removeFirst();
            }

            // Remove indices of smaller elements from the rear
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }

            // Add the current index to the rear
            dq.addLast(i);
        }

        // Add the maximum element of the last window to the result
        result.add(arr[dq.peekFirst()]);

        return result;
    }
}