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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        solve(root,0,ans);
        // Queue<TreeNode> q = new LinkedList<>();

        // q.add(root);

        // while(!q.isEmpty()){
        //     int size = q.size();

        //     Integer rightMostNodeValue = null;

        //     for(int i=0;i<size;i++){
        //         TreeNode node = q.poll();
        //         rightMostNodeValue = node.val;

        //         if (node.left != null) q.offer(node.left);
        //         if (node.right != null) q.offer(node.right);
        //     }
        //     ans.add(rightMostNodeValue);
        // }

        return ans;
    }

    public void solve(TreeNode root, int depth,List<Integer> ans){

        if(root == null) return;

        if(depth == ans.size())ans.add(root.val);

        solve(root.right,depth+1,ans);
        solve(root.left,depth+1,ans);
    }
}