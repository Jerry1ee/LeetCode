package 按之字形顺序打印二叉树;

public class Main {
    public static void main(String[] args)
    {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);
        node1.right.left = new TreeNode(6);
        node1.right.right = new TreeNode(7);

        new Solution().Print(node1);

    }
}
