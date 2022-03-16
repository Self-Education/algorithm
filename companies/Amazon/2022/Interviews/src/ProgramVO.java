import customClass.Expression;

public class ProgramVO {
    public static void expressionEvaluateI(SolutionVO solution) {
        System.out.println("Expected answer is " + "5x^5+2x^2-x-4" + "; Output is "
                + solution.prettyPrint("2x^2 + 7x^1 + (-5x^0) - (-5x^5 + 8x - 1)"));
        System.out.println("Expected answer is " + "2" + "; Output is "
                + solution.evaluate("2x^2 + 7x^1 + (-5x^0) - (-5x^5 + 8x - 1)", 1));
        System.out.println("Expected answer is " + "3x^3+9x^2+7x+9" + "; Output is "
                + solution.prettyPrint("3x^3 + 9x^2 + 7x + 9"));
        System.out.println("Expected answer is " + "28" + "; Output is "
                + solution.evaluate("3x^3 + 9x^2 + 7x + 9", 1));
    }

    public static void formWordFromCards(SolutionVO solution) {
        System.out.println("Expected answer is " + "true" + "; Output is "
                + solution.formWordFromCards(new char[][] { { 'a', 'b' }, { 'a', 'b' }, { 'a', 'b' }, { 'x', 'y' } },
                        "baby"));
        System.out.println("Expected answer is " + "false" + "; Output is "
                + solution.formWordFromCards(new char[][] { { 'a', 'b' }, { 'a', 'b' }, { 'x', 'y' } },
                        "baby"));
    }

    public static void evaluateExpressionII(SolutionVO solution) {
        Expression p1 = new Expression("+", new int[] { 2, 3 });
        Expression p2 = new Expression(5);
        Expression p3 = new Expression("-", new int[] { 10, 0, -5
        });
        Expression input = new Expression("*", new Expression[] { p1, p2, p3 });
        System.out.println("Expected answer is " + "375" + "; Output is "
                + solution.evaluateExpressionII(input));

    }

    public static void main(String[] args) {
        SolutionVO solution = new SolutionVO();
        // expressionEvaluateI(solution);
        // formWordFromCards(solution);
        evaluateExpressionII(solution);
    }
}
