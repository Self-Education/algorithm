package Interviews.src;

public class ProgramVO {
    public static void expressionEvaluateI(SolutionVO solution) {
        System.out.println("Expected answer is " + "5x^5+2x^2-x-4" + "; Output is "
                + solution.prettyPrint("2x^2 + 7x^1 + (-5x^0) - (-5x^5 + 8x - 1)"));
    }

    public static void main(String[] args) {
        SolutionVO solution = new SolutionVO();
        expressionEvaluateI(solution);
    }
}
