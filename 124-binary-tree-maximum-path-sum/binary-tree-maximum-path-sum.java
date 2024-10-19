/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int ans[]= new int[1];
        ans[0]=Integer.MIN_VALUE;
        maxSum(root,ans);

        return ans[0];
    }

    public int maxSum(TreeNode root, int ans[]){

        if(root==null)return 0;

        int left=maxSum(root.left,ans);
        int right=maxSum(root.right,ans);

        // node can either return itself or any one of its children
        int ret= Math.max(root.val,Math.max(left,right)+root.val);

        // ans can pass through the current node where we can consider both right + left + root.val
        ans[0]=Math.max(ans[0],left+right+root.val);

        // Given that even single node can be max sum path 
        // we compare with value we are returning to get max
        ans[0]=Math.max(ans[0],ret);

        return ret;
    }
}