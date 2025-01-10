class Solution {
    public Node linkdelete(Node head, int n, int m) {
        //Your linked list deletion logic from the previous responses would go here.
        //This would be nearly identical to the LinkedList.deleteNodes method, but
        //within the Solution class.  You can adapt it directly.
        //Remember to handle edge cases (empty list, m>length, n>length).
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null) return head;

            Node temp = curr.next;
            for (int i = 0; i < n && temp != null; i++) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }
}