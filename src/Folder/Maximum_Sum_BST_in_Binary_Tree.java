class Solution {
    int maxSum = 0;  //maxSum initialized to maintain it at every step and made global so no need to pass in function
    class NodePair{ /// this class will be viewed as a single node of tree
    int min, max, sum;
    }
    public NodePair getSum(TreeNode root){
        if(root == null){  // if null then return sum 0 and minimum value as Int max and max value as Int min
            NodePair a = new NodePair();
            a.min = Integer.MAX_VALUE;
            a.max = Integer.MIN_VALUE;
            a.sum = 0;
            return a;
        }
        NodePair main = new NodePair();
        NodePair left = getSum(root.left);  //recursion till leftmost node
        NodePair right = getSum(root.right);  //recursion till rightmost node

        if(left.max < root.val && root.val < right.min){  //validating the bst
            main.min = Math.min(root.val, Math.min(left.min, right.min));
            main.max = Math.max(root.val, Math.max(left.max, right.max));
            main.sum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum,main.sum);
        }
        else{
            main.min = Integer.MIN_VALUE;  // if not bst then just pass the sum calculated as of now
            main.max = Integer.MAX_VALUE;
            main.sum = Math.max(left.sum,right.sum);
        }
        return main;
    }
    public int maxSumBST(TreeNode root) {
        NodePair temp = new NodePair();
        temp = getSum(root);
        return maxSum > 0 ? maxSum : 0;
    }
}