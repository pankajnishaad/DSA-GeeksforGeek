/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    static int maxPathSumUtil(Node root, int[] res)
        {
            if (root == null)
                return 0;

            if (root.left == null && root.right == null)
                return root.data;

            int leftSum = maxPathSumUtil(root.left, res);
            int rightSum = maxPathSumUtil(root.right, res);

            if (root.left != null && root.right != null) {
                // Combine both root-to-leaf paths through the
                // current node.
                res[0] = Math.max(res[0], leftSum + rightSum
                                              + root.data);
                return Math.max(leftSum, rightSum) + root.data;
            }

            if (root.left != null)
                return leftSum + root.data;

            return rightSum + root.data;
        }
    public int maxPathSum(Node root) 
    {
        // code here
        if (root == null)
            return -1;

        int[] res = { Integer.MIN_VALUE };
        maxPathSumUtil(root, res);

        return res[0] == Integer.MIN_VALUE ? -1 : res[0];        
    }
    

}