import dataStructure.TreeNode;

public class CheckTreeBalance {

    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int l = getTreeDepth(root.left, 1);
        int r = getTreeDepth(root.right, 1);
        boolean mid = Math.abs(l - r) > 1 ? false : true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return mid && left && right;
    }

    public static int getTreeDepth(TreeNode root, int height) {
        if (root.left == null && root.right == null)
            return height;
        int left = getTreeDepth(root.left, height + 1);
        int right = getTreeDepth(root.right, height + 1);
        return left > right ? left : right;
    }
}
