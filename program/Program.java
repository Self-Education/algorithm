// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Stack;



public class Program {
    public static void main(String[] args) {
        // TreeSolution treeSolution = new TreeSolution();
        // TreeNode root = new TreeNode(0);
        // int[] nums = new int[] {1, 2, 3, 4, 5};
        // TreeNode node = treeSolution.minimalTree(nums);
        // TreeNodePrinter treeNodePrinter = new TreeNodePrinter();
        // treeNodePrinter.print(node, 0);
        // ArrayList<List<Integer>> ans = treeSolution.dfsTreeList(node);
        // System.out.println(Arrays.toString(ans.toArray()));
        System.out.println("hello");
        String pattern = "abcdf";
        String text = "abcdabcabcdf";
        StringSolution stringSolution = new StringSolution();
        Printer.printArray(stringSolution.getPrefixTable(pattern));
        System.out.println(String.format("KMP pattern search %s",
                stringSolution.KMPPatternSearch(text, pattern)));
    }
}
