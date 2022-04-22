import java.util.*;

public class TestOA {

    private static void sortAB(SolutionOA solution) {
        String s1 = "BAAABAB";
        System.out.println(
                String.format("Expected anser is %s, result is %s", 2, solution.sortAB(s1)));
    }

    private static void evenPairs(SolutionOA solution) {
        int[] arr1 = new int[] {4, 2, 5, 6, 7, 3, 7};
        int[] arr2 = new int[] {14, 21, 16, 35, 22};
        int[] arr3 = new int[] {5, 5, 5, 5, 5, 5};
        System.out.println(String.format("Input is %s, Expected anser is %s, result is %s",
                Arrays.toString(arr1), 2, solution.evenPairs(arr1)));
        System.out.println(String.format("Input is %s, Expected anser is %s, result is %s",
                Arrays.toString(arr2), 1, solution.evenPairs(arr2)));
        System.out.println(String.format("Input is %s, Expected anser is %s, result is %s",
                Arrays.toString(arr3), 3, solution.evenPairs(arr3)));
    }

    private static void remove5(SolutionOA solution) {
        int num1 = -9995;
        int num2 = 15456;
        int num3 = -15456;
        int num4 = 555453;
        int num5 = -555453;

        System.out.println(String.format("Input is %s, Expected anser is %s, result is %s", num1,
                -999, solution.remove5(num1)));
        System.out.println(String.format("Input is %s, Expected anser is %s, result is %s", num2,
                1546, solution.remove5(num2)));
        System.out.println(String.format("Input is %s, Expected anser is %s, result is %s", num3,
                -1456, solution.remove5(num3)));
        System.out.println(String.format("Input is %s, Expected anser is %s, result is %s", num4,
                55543, solution.remove5(num4)));
        System.out.println(String.format("Input is %s, Expected anser is %s, result is %s", num5,
                -55453, solution.remove5(num5)));
    }

    public static void main(String[] args) {
        SolutionOA solution = new SolutionOA();

        // sortAB(solution);
        // evenPairs(solution);
        remove5(solution);
    }
}
