import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class TreeSolution {
    public ArrayList<List<Integer>> dfsTreeList;

    public TreeNode array2BST(int[] nums) {
        TreeNode node = null;
        for (int i = 0; i < nums.length; i++) {
            node = insertNode(node, nums[i]);
        }

        return node;
    }

    public TreeNode insertNode(TreeNode node, int val) {
        if (node == null)
            return new TreeNode(val);
        if (val < node.val) {
            node.left = insertNode(node.left, val);
        } else if (val > node.val) {
            node.right = insertNode(node.right, val);
        }
        return node;
    }


    /*
     * Given an array in ascending order, convert it into a binary search tree with minima height
     */
    public TreeNode minimalTree(int[] nums) {
        if (nums.length <= 0)
            return null;
        return createMinimalTree(nums, 0, nums.length - 1);
    }

    public TreeNode createMinimalTree(int[] nums, int start, int end) {
        if (start > end)
            return null;

        // find the middle pivot as root;
        int pivot = (start + end) / 2;
        TreeNode root = new TreeNode(nums[pivot]);
        root.left = createMinimalTree(nums, start, pivot - 1);
        root.right = createMinimalTree(nums, pivot + 1, end);
        return root;
    }

    /*
     * create a list of list, in which each list is the collection of nodes in each level.
     */
    public ArrayList<List<Integer>> dfsTreeList(TreeNode node) {
        dfsTreeList = new ArrayList<>();
        dfsTreeListHelper(node, 0);
        return dfsTreeList;
    }

    public void dfsTreeListHelper(TreeNode node, int level) {
        if (node == null)
            return;
        if (level == dfsTreeList.size()) {

            dfsTreeList.add(new LinkedList<>());
        }
        dfsTreeList.get(level).add(node.val);

        dfsTreeListHelper(node.left, level + 1);
        dfsTreeListHelper(node.right, level + 1);
    }

    /*
     * Check if a binary tree is balanced
     */
    public boolean isTreeBalanced(TreeNode root) {
        if (root == null)
            return true;
        int l = getTreeDepth(root.left);
        int r = getTreeDepth(root.right);
        // length difference of two subtrees of current node is not greater than 1
        // && these two subtrees are balanced as well.
        return Math.abs(l - r) > 1 && isTreeBalanced(root.left) && isTreeBalanced(root.right);
    }

    // return max depth of tree/subtree with root 'node'.
    public int getTreeDepth(TreeNode node) {
        if (node == null)
            return 0;
        int l = getTreeDepth(node.left);
        int r = getTreeDepth(node.right);
        return Math.max(l, r) + 1;
    }
}
