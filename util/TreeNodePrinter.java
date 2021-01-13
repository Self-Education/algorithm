import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class TreeNodePrinter {
    List<Integer> list = new LinkedList<>();

    public void print(TreeNode node, int val) {

        // 0: preorder, 1: inorder, 2: postorder
        switch (val) {
            case 0:
                preorder(node);
                break;
            case 1:
                inorder(node);
                break;
            case 2:
                postorder(node);
                break;
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public void preorder(TreeNode node) {
        if (node == null)
            return;
        list.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(TreeNode node) {

    }

    public void postorder(TreeNode Node) {

    }
}
