package 按之字形顺序打印二叉树;
import java.util.*;


 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}


public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > resList = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        stack1.push(pRoot);
        while(!stack1.empty()||!stack2.empty())
        {
            ArrayList<Integer> subList = new ArrayList<Integer>();
            while(!stack1.empty())
            {
                TreeNode tmp = stack1.pop();
                if(tmp!=null)
                {
                    stack2.push(tmp.left);
                    stack2.push(tmp.right);
                    subList.add(tmp.val);
                }

            }
            if(!subList.isEmpty())
                resList.add(new ArrayList<Integer>(subList));
            subList.clear();
            while(!stack2.empty())
            {

                TreeNode tmp = stack2.pop();
                if(tmp!=null)
                {
                    stack1.push(tmp.right);
                    stack1.push(tmp.left);
                    subList.add(tmp.val);
                }

            }
            if(!subList.isEmpty())
                resList.add(new ArrayList<Integer>(subList));
            subList.clear();
        }
        return resList;
    }

}