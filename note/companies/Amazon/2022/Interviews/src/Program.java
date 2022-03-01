package Interviews.src;

public class Program {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        // armorGameTester(solution);
        // decreasingRatingTester(solution);
        minMovesToGroupOneAndZeroTester(solution);
    }

    private static void armorGameTester(Solution solution) {
        int[] power1 = new int[] {1, 2, 6, 7};
        int armor1 = 5;
        System.out.println(
                "Expected answer is " + 12 + "; Output is " + solution.armorGame(power1, armor1));
    }

    private static void decreasingRatingTester(Solution solution) {
        int[] ratings1 = new int[] {4, 3, 5, 4, 3};
        int[] ratings2 = new int[] {3, 2, 1};
        int[] ratings3 = new int[] {9, 8, 7, 6, 5};
        System.out.println(
                "Expected answer is " + 9 + "; Output is " + solution.decreasingRating(ratings1));
        System.out.println(
                "Expected answer is " + 6 + "; Output is " + solution.decreasingRating(ratings2));
        System.out.println(
                "Expected answer is " + 15 + "; Output is " + solution.decreasingRating(ratings3));

    }

    private static void minMovesToGroupOneAndZeroTester(Solution solution) {
        int[] arr1 = new int[] {0, 1, 0, 1};
        int[] arr2 = new int[] {1, 0, 1, 0};
        int[] arr3 = new int[] {1, 0, 0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.minMovesToGroupOneAndZero(arr1));
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.minMovesToGroupOneAndZero(arr2));
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.minMovesToGroupOneAndZero(arr3));
    }

}
