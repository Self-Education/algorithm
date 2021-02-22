// import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
// import java.util.List;
// import java.util.Stack;



public class Program {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-2);
        right.right = node3;
        root.left = left;
        root.right = right;
        left.left = node1;
        left.right = node2;
        // BSTSqeuence bst = new BSTSqeuence();
        Printer.printTree(root, 0);
        // LinkedList<LinkedList<Integer>> ans = bst.solution(root);
        // Printer.print(Arrays.toString(ans.toArray()));
        // LinkedList<Integer> test = new LinkedList<>();
        // test.add(0);
        // test.add(1);
        // test.add(2);
        // Printer.print(Arrays.toString(test.toArray()));
        // LinkedList<Integer> copy = test;
        // test.removeLast();
        // Printer.print(Arrays.toString(test.toArray()));
        // Printer.print(Arrays.toString(copy.toArray()));
        Printer.print(PathSum.pathSumI(root, 3));



    }
}
