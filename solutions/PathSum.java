public class PathSum {

    /*
     * Path sum: count number of paths, each of path'sum equals the given value, path does not need
     * to start to end at leaf or root, but must go downward Leetcode @ 437
     */
    static int numOfPath;

    public static int pathSumIII(TreeNode root, int val) {
        numOfPath = 0;
        helper(root, val, 0);
        pathSumIII(root.left, val);
        pathSumIII(root.right, val);
        return numOfPath;
    }

    public static void helper(TreeNode root, int target, int sum) {
        if (root == null)
            return;
        if (sum == target) {
            numOfPath++;
        }
        sum += root.val;
        helper(root.left, target, sum);
        helper(root.right, target, sum);
    }
}
