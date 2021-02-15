import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Printer {

    /*
     * Print a string
     */

    public static void print(String str) {
        System.out.println(str);
    }

    /*
     * print a stack
     */
    public static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int temp = stack.pop();
        printStack(stack);
        System.out.print(temp + " ");
        // push the poped element back
        stack.push(temp);
    }

    /*
     * 
     * Print tree in the different orders
     * 
     * @param Node to be printed
     * 
     * @param val the order of reading tree, 0: preorder, 1: inorder, 2: postorder
     * 
     */
    public void printTree(TreeNode node, int val) {
        LinkedList<Integer> list = new LinkedList<>();
        // 0: preorder, 1: inorder, 2: postorder
        switch (val) {
            case 0:
                list = preorder(node);
                break;
            case 1:
                list = inorder(node);
                break;
            case 2:
                list = postorder(node);
                break;
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public LinkedList<Integer> preorder(TreeNode node) {
        LinkedList<Integer> list = new LinkedList<>();
        if (node == null)
            return list;
        list.add(node.val);
        preorder(node.left);
        preorder(node.right);
        return list;
    }

    public LinkedList<Integer> inorder(TreeNode node) {
        return null;
    }

    public LinkedList<Integer> postorder(TreeNode Node) {
        return null;
    }

    /*
     * print array
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(char[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
