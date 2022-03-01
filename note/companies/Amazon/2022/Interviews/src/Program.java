package Interviews.src;

public class Program {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        // armorGameTester(solution);
        // decreasingRatingTester(solution);
        // minMovesToGroupOneAndZeroTester(solution);
        // findMaxSustainableClusterSizeTester(solution);
        // separatePrimesTester(solution);
        // remove5Tester(solution);
        // partitionBracketArrayTester(solution);
        // groupMovieTester(solution);
        threePages(solution);
    }

    private static void armorGameTester(Solution solution) {
        int[] power1 = new int[] { 1, 2, 6, 7 };
        int armor1 = 5;
        System.out.println(
                "Expected answer is " + 12 + "; Output is " + solution.armorGame(power1, armor1));
    }

    private static void decreasingRatingTester(Solution solution) {
        int[] ratings1 = new int[] { 4, 3, 5, 4, 3 };
        int[] ratings2 = new int[] { 3, 2, 1 };
        int[] ratings3 = new int[] { 9, 8, 7, 6, 5 };
        System.out.println(
                "Expected answer is " + 9 + "; Output is " + solution.decreasingRating(ratings1));
        System.out.println(
                "Expected answer is " + 6 + "; Output is " + solution.decreasingRating(ratings2));
        System.out.println(
                "Expected answer is " + 15 + "; Output is " + solution.decreasingRating(ratings3));

    }

    private static void minMovesToGroupOneAndZeroTester(Solution solution) {
        int[] arr1 = new int[] { 0, 1, 0, 1 };
        int[] arr2 = new int[] { 1, 0, 1, 0 };
        int[] arr3 = new int[] { 1, 0, 0, 1, 0, 1, 1, 0, 0, 1 };
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.minMovesToGroupOneAndZero(arr1));
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.minMovesToGroupOneAndZero(arr2));
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.minMovesToGroupOneAndZero(arr3));
    }

    private static void findMaxSustainableClusterSizeTester(Solution solution) {
        int[] bootPower1 = new int[] { 3, 6, 1, 3, 4 };
        int[] processingPower1 = new int[] { 2, 1, 3, 4, 5 };
        int maxPower1 = 25;

        int[] bootPower2 = new int[] { 10, 20, 12, 16 };
        int[] processingPower2 = new int[] { 15, 10, 11, 13 };
        int maxPower2 = 100;
        System.out.println("Expected answer is " + 3 + "; Output is "
                + solution.findMaxSustainableClusterSize(processingPower1, bootPower1, maxPower1));
        System.out.println("Expected answer is " + 2 + "; Output is "
                + solution.findMaxSustainableClusterSize(processingPower2, bootPower2, maxPower2));
    }

    private static void separatePrimesTester(Solution solution) {
        int[] arr1 = new int[] { 1, 2, 4, 8, 9, 11, 15, 17, 27, 25, 28 };
        int[] arr2 = new int[] { 1 };
        System.out.println("Expected answer is [[2, 11, 17],[1, 4, 5, 9, 15, 27, 25, 28]]" + "; Output is "
                + solution.separatePrimes(arr1));

    }

    private static void remove5Tester(Solution solution) {
        int num1 = 15958;
        int num2 = 15354;
        int num3 = 155555;
        int num4 = 1234;
        int num5 = 543;

        System.out.println("Expected answer is " + 1958 + "; Output is " + solution.remove5(num1));
        System.out.println("Expected answer is " + 1534 + "; Output is " + solution.remove5(num2));
        System.out.println("Expected answer is " + 15555 + "; Output is " + solution.remove5(num3));
        System.out.println("Expected answer is " + -1 + "; Output is " + solution.remove5(num4));
        System.out.println("Expected answer is " + 43 + "; Output is " + solution.remove5(num5));
    }

    private static void partitionBracketArrayTester(Solution solution) {
        String s1 = "[(?][??]";
        String s2 = "][[[??]";
        System.out.println("Expected answer is " + 2 + "; Output is " + solution.partitionBracketArray(s1));
        System.out.println("Expected answer is " + 1 + "; Output is " + solution.partitionBracketArray(s2));
    }

    private static void groupMovieTester(Solution solution) {
        int[] movies1 = new int[] { 1, 5, 4, 6, 8, 9, 2 };
        int k1 = 3;
        System.out.println("Expected answer is " + 3 + "; Output is " + solution.groupMovie(movies1, k1));
    }

    private static void threePages(Solution solution) {
        String book1 = "10111";
        String book2 = "01001";
        String book3 = "0001";

        System.out.println("Expected answer is " + 3 + "; Output is " + solution.threePages(book1));
        System.out.println("Expected answer is " + 4 + "; Output is " + solution.threePages(book2));
        System.out.println("Expected answer is " + 0 + "; Output is " + solution.threePages(book3));
    }
}
