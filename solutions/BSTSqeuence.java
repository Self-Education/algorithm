import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BSTSqeuence {
    /*
     * BST Sequence, return all possible arrays that could led to the input tree
     */
    LinkedList<LinkedList<Integer>> ans;

    public LinkedList<LinkedList<Integer>> solution(TreeNode root) {
        ans = new LinkedList<>();
        if (root == null)
            return ans;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> options = new LinkedList<>();
        list.add(root.val);
        if (root.left != null)
            options.add(root.left);
        if (root.right != null)
            options.add(root.right);
        backtrack(options, list);
        return ans;
    }

    public void backtrack(LinkedList<TreeNode> options, LinkedList<Integer> sublist) {
        if (options.isEmpty()) {
            ans.add(new LinkedList<Integer>(sublist));
            return;
        }
        LinkedList<Integer> copyList = new LinkedList<Integer>(sublist);
        LinkedList<TreeNode> copyOptions = new LinkedList<TreeNode>(options);
        for (int i = 0; i < copyOptions.size(); ++i) {
            sublist = copyList;
            options = copyOptions;
            // System.out.println(" before , i is " + i);
            // System.out.println("options are");
            // Printer.printListNode(options);
            TreeNode cur = options.get(i);
            sublist.add(cur.val);
            // System.out.println("cur val is ");
            // System.out.println(cur.val);
            // System.out.println("sublist is");
            // System.out.println(Arrays.toString(sublist.toArray()));

            options.remove(i);
            if (cur.left != null) {
                options.add(cur.left);
            }

            if (cur.right != null) {
                options.add(cur.right);
            }
            backtrack(options, sublist);
            System.out.println(" after, i is " + i);

        }
    }
}
