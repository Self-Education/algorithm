import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import dataStructure.TreeNode;

public class TreeSolution {
    public ArrayList<List<Integer>> dfsTreeList;
    public List<List<TreeNode>> BSTSequenceAns = new LinkedList<>();
    public int countOfUnivalSubtree;

    /*
     * convert array into Binary Search Tree
     */
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
     * Given an array in ascending order, convert it into a binary search tree with
     * minima height
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
     * create a list of list, in which each list is the collection of nodes in each
     * level.
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

    /*
     * Check if a binary tree is a BST (binary search tree) for each node, all left
     * childeren < node
     * < right children
     */
    public boolean isBST(TreeNode node) {
        // cannot say node.left < node && node.right > node && isBST(node.left) == true
        // &&
        // isBST(node.right) == true
        // since this cannot gurantee right side node in the right subtree is smaller
        // than parent or
        // its eft subtree

        // use low limit and high limit, make current node between low and high
        return isBSTHelper(node, null, null);
    }

    public boolean isBSTHelper(TreeNode node, Integer low, Integer high) {
        if (node == null)
            return true;
        if ((low == null || node.val > low) && (high == null || node.val < high)
                && isBSTHelper(node.left, low, node.val - 1)
                && isBSTHelper(node.right, node.val + 1, high)) {
            return true;
        }
        return false;
    }

    /*
     * check if T2 is T1's subtree
     */
    public boolean isSubtree(TreeNode t1, TreeNode t2) {

        int mid = (t1.val == t2.val && ifEqual(t1.left, t2.left)) ? 1 : 0;
        int left = isSubtree(t1.left, t2) ? 1 : 0;
        int right = isSubtree(t1.right, t2) ? 1 : 0;
        return (mid + left + right) >= 1;
    }

    public boolean ifEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;

        return t1.val == t2.val && ifEqual(t1.left, t2.left) && ifEqual(t1.right, t2.right);
    }

    /*
     * Univalue, find number of unival-subtrees in a tree, uni-subtree has all nodes
     * with the same
     * value
     */

    public int countUnivalSubtree(TreeNode root) {
        // check if the entire tree is unival subtree
        countOfUnivalSubtree = 0;
        if (root == null)
            return 0;
        ifUni(root);
        return countOfUnivalSubtree;
    }

    public boolean ifUni(TreeNode root) {
        // leaf is always unival tree
        if (root.left == null && root.right == null)
            countOfUnivalSubtree += 1;
        boolean result = true;
        if (root.left != null) {
            result = ifUni(root.left) && root.left.val == root.val;
        }
        if (root.right != null) {
            result = ifUni(root.right) && result && root.right.val == root.val;
        }
        if (result)
            countOfUnivalSubtree++;
        return result;

    }
}
