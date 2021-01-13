import java.util.Stack;

public class StackPrinter {


    public void printStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int temp = stack.pop();
        printStack(stack);
        System.out.print(temp + " ");
        // push the poped element back
        stack.push(temp);
    }
}
