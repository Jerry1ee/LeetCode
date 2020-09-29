package Q145二叉树的后序遍历;

import java.util.*;


//Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList();
        Stack<TreeNode> stack = new Stack();

        TreeNode pre = null;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.right==null||root.right==pre){
                resList.add(root.val);
                pre = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }

        return resList;
    }
}