package Q530二叉搜索树的最小绝对差;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int pre;
    int res;
    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root){
        if(root == null)return;
        dfs(root.left);
        if(pre == -1){
            pre = root.val;
        }else{
            res = Math.min(root.val-pre,res);
            pre = root.val;
        }
        dfs(root.right);
    }
}
