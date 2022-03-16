import java.util.Stack;

public class StackQueueSolution {
    //
    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> sorted = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!sorted.isEmpty() && sorted.peek() > temp) {
                stack.push(sorted.pop());
            }
            sorted.push(temp);
        }

        while (!sorted.isEmpty()) {
            stack.push(sorted.pop());
        }
    }
}
