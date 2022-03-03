package Interviews.src;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Program {

    private static void campingDay(Solution solution) {
        System.out.println("Expected answer is " + "[3, 4]" + "; Output is "
                + solution.campingDay(new int[] { 3, 2, 2, 2, 3, 4 }, 2));
        System.out.println("Expected answer is " + "[2, 4]" + "; Output is "
                + solution.campingDay(new int[] { 1, 0, 1, 0, 1 }, 1));
        System.out.println("Expected answer is " + "[4, 5, 6, 7]" + "; Output is "
                + solution.campingDay(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 3));
    }

    private static void armorGameTester(Solution solution) {
        int[] power1 = new int[] { 1, 2, 6, 7 };
        int armor1 = 5;
        System.out.println("Expected answer is " + 12 + "; Output is "
                + solution.armorGame(power1, armor1));
    }

    private static void decreasingRatingTester(Solution solution) {
        int[] ratings1 = new int[] { 4, 3, 5, 4, 3 };
        int[] ratings2 = new int[] { 3, 2, 1 };
        int[] ratings3 = new int[] { 1, 0, 0, 1, 0, 1, 1, 0, 0, 1 };
        System.out.println("Expected answer is " + 9 + "; Output is "
                + solution.decreasingRating(ratings1));
        System.out.println("Expected answer is " + 6 + "; Output is "
                + solution.decreasingRating(ratings2));
        System.out.println("Expected answer is " + 15 + "; Output is "
                + solution.decreasingRating(ratings3));

    }

    private static void minMovesToGroupOneAndZeroTester(Solution solution) {
        int[] arr1 = new int[] { 0, 1, 0, 1 };
        int[] arr2 = new int[] { 1, 0, 1, 0 };
        int[] arr3 = new int[] { 1, 0, 0, 1, 0, 1, 1, 0, 0, 1 };
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.minMovesToGroupOneAndZero(arr1));
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.minMovesToGroupOneAndZero(arr2));
        System.out.println("Expected answer is " + 12 + "; Output is "
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
                + solution.findMaxSustainableClusterSize(processingPower1,
                        bootPower1, maxPower1));
        System.out.println("Expected answer is " + 2 + "; Output is "
                + solution.findMaxSustainableClusterSize(processingPower2,
                        bootPower2, maxPower2));
    }

    private static void separatePrimesTester(Solution solution) {
        int[] arr1 = new int[] { 1, 2, 4, 8, 9, 11, 15, 17, 27, 25, 28 };
        int[] arr2 = new int[] { 1 };
        System.out.println("Expected answer is [[2, 11, 17],[1, 4, 5, 9, 15, 27, 25, 28]]"
                + "; Output is " + solution.separatePrimes(arr1));

    }

    private static void remove5Tester(Solution solution) {
        int num1 = 15958;
        int num2 = 15354;
        int num3 = 155555;
        int num4 = 1234;
        int num5 = 543;

        System.out.println("Expected answer is " + 1958 + "; Output is "
                + solution.remove5(num1));
        System.out.println("Expected answer is " + 1534 + "; Output is "
                + solution.remove5(num2));
        System.out.println("Expected answer is " + 15555 + "; Output is "
                + solution.remove5(num3));
        System.out.println("Expected answer is " + -1 + "; Output is "
                + solution.remove5(num4));
        System.out.println("Expected answer is " + 43 + "; Output is "
                + solution.remove5(num5));
    }

    private static void partitionBracketArrayTester(Solution solution) {
        String s1 = "[(?][??]";
        String s2 = "][[[??]";
        System.out.println("Expected answer is " + 2 + "; Output is "
                + solution.partitionBracketArray(s1));
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.partitionBracketArray(s2));
    }

    private static void groupMovieTester(Solution solution) {
        int[] movies1 = new int[] { 1, 5, 4, 6, 8, 9, 2 };
        int k1 = 3;
        System.out.println("Expected answer is " + 3 + "; Output is "
                + solution.groupMovie(movies1, k1));
    }

    private static void threePages(Solution solution) {
        String book1 = "10111";
        String book2 = "01001";
        String book3 = "0001";

        System.out.println("Expected answer is " + 3 + "; Output is "
                + solution.threePages(book1));
        System.out.println("Expected answer is " + 4 + "; Output is "
                + solution.threePages(book2));
        System.out.println("Expected answer is " + 0 + "; Output is "
                + solution.threePages(book3));
    }

    private static void longestOneProudctSubarray(Solution solution) {
        int[] arr1 = new int[] { 1, -1, -1, 1, -1, 1 };
        int[] arr2 = new int[] { -1, -1, -1, -1, -1 };
        System.out.println("Expected answer is " + 4 + "; Output is "
                + solution.longestOneProudctSubarray(arr1));
        System.out.println("Expected answer is " + 4 + "; Output is "
                + solution.longestOneProudctSubarray(arr2));

    }

    private static void mergePackage(Solution solution) {
        int[] arr1 = new int[] { 2, 9, 10, 3, 7 };
        int[] arr2 = new int[] { 10, 5, 7 };
        System.out.println("Expected answer is " + 21 + "; Output is "
                + solution.mergePackage(arr1));
        System.out.println("Expected answer is " + 22 + "; Output is "
                + solution.mergePackage(arr2));
    }

    private static void kthBestCombo(Solution solution) {
        int[] arr1 = new int[] { 3, 5, -2 };
        int k1 = 3;
        System.out.println("Expected answer is " + "[8,6,5]" + "; Output is "
                + solution.kthBestCombo(arr1, k1));
    }

    private static void wifiRouter(Solution solution) {
        int[] buildingCount1 = new int[] { 1, 2, 1, 2, 2 };
        int[] routerLocation1 = new int[] { 3, 1 };
        int[] routerRange1 = new int[] { 1, 2 };
        System.out.println("Expected answer is " + 3 + "; Output is " + solution
                .wifiRouter(buildingCount1, routerLocation1, routerRange1));
    }

    private static void minCostFullLoadTruck(Solution solution) {
        int[] p1 = new int[] { 2, 3, 6, 10, 11 };
        int k1 = 9;
        System.out.println("Expected answer is " + 17 + "; Output is "
                + solution.minCostFullLoadTruck(p1, k1));
    }

    private static void minimizeMemory(Solution solution) {
        int[] arr1 = new int[] { 10, 4, 8, 1 };
        int k1 = 2;
        System.out.println("Expected answer is " + 9 + "; Output is "
                + solution.minimizeMemory(arr1, k1));
    }

    private static void findVowelPasswordStrength(Solution solution) {
        String s1 = "thisisbeautiful";
        String s2 = "hackerrank";
        String s3 = "aeiou";

        System.out.println("Expected answer is " + 6 + "; Output is "
                + solution.findVowelPasswordStrength(s1));
        System.out.println("Expected answer is " + 3 + "; Output is "
                + solution.findVowelPasswordStrength(s2));
        System.out.println("Expected answer is " + 0 + "; Output is "
                + solution.findVowelPasswordStrength(s3));
    }

    private static void pascalEncode(Solution solution) {
        String s1 = "3456";
        System.out.println("Expected answer is " + 60 + "; Output is "
                + solution.pascalEncode(s1));
    }

    private static void sortOrder(Solution solution) {
        List<String> orders = new LinkedList<>();
        orders.add("aax 12 23");
        orders.add("sde 1 00");
        orders.add("ff kindle ebook");
        orders.add("wed abc zz");
        orders.add("a2 kindle ebook");
        System.out.println("here");

        System.out.println("Expected answer is " + "NA" + "; Output is "
                + solution.sortOrder(orders));
    }

    private static void maxSegmentProfit(Solution solution) {
        int[] profits1 = new int[] { 1, 5, 1, 3, 7, -3 };
        int k1 = 2;
        int[] profits2 = new int[] { -6, 3, 6, -3 };
        int k2 = 1;
        System.out.println("Expected answer is " + 16 + "; Output is "
                + solution.maxSegmentProfit(profits1, k1));
        System.out.println("Expected answer is " + 0 + "; Output is "
                + solution.maxSegmentProfit(profits2, k2));
    }

    private static void discountTag(Solution solution) {
        String[][] products = new String[][] { { "10", "d0", "d1" }, { "15", "EMPTY", "EMPTY" },
                { "20", "d1", "EMPTY" } };
        String[][] discounts = new String[][] { { "d0", "1", "27" }, { "d1", "2", "5" } };
        System.out.println("Expected answer is " + 35 + "; Output is "
                + solution.discountTag(products, discounts));
    }

    private static void maxQuality(Solution solution) {
        System.out.println("Expected answer is " + 8 + "; Output is "
                + solution.maxQuality(new int[] { 1, 2, 3, 4, 5 }, 2));
        System.out.println("Expected answer is " + 7 + "; Output is "
                + solution.maxQuality(new int[] { 2, 2, 1, 5, 3 }, 2));
        System.out.println("Expected answer is " + 151 + "; Output is "
                + solution.maxQuality(new int[] { 89, 48, 14 }, 3));
    }

    // 1
    private static void subarrayImbalance(Solution solution) {

    }

    private static void shipmentImbalance(Solution solution) {
        System.out.println("Expected answer is " + 5 + "; Output is "
                + solution.shipmentImbalance(new int[] { 1, 3, 2 }));
        System.out.println("Expected answer is " + 59 + "; Output is "
                + solution.shipmentImbalance(new int[] { 4, -2, -3, 4, 1 }));
    }

    private static void grayScale(Solution solution) {
        System.out.println("Expected answer is " + 9 + "; Output is "
                + solution.grayScale(new int[] { 6, -2, 5 }));
    }

    private static void maxAggTemperature(Solution solution) {
        System.out.println("Expected answer is " + 9 + "; Output is "
                + solution.maxAggTemperature(new int[] { 6, -2, 5 }));
    }

    private static void removeInvalidParenthese(Solution solution) {
        System.out.println("Expected answer is " + "a(b)cd" + "; Output is "
                + solution.removeInvalidParenthese("a(b))c(d"));
        System.out.println("Expected answer is " + "(((())))" + "; Output is "
                + solution.removeInvalidParenthese("(((())))"));
    }

    private static void validGroupon(Solution solution) {
        System.out.println("Expected answer is " + "[1, 1, 1, 1]" + "; Output is "
                + Arrays.toString(solution.validGroupon(new String[] { "vv", "xbbx", "bbccdd", "xyffyxdd" })));
    }

    private static void maxNumberOfEngineeringTeam(Solution solution) {
        System.out.println("Expected answer is " + 6 + "; Output is "
                + solution.maxNumberOfEngineeringTeam(1, 1, new int[] { 34, 5, 72, 48, 15, 2
                }));
        System.out.println("Expected answer is " + 1 + "; Output is "
                + solution.maxNumberOfEngineeringTeam(3, 20, new int[] { 34, 5, 72, 48, 15, 2
                }));
        System.out.println("Expected answer is " + 2 + "; Output is "
                + solution.maxNumberOfEngineeringTeam(3, 40, new int[] { 34, 5, 72, 48, 15, 2 }));
        System.out.println("Expected answer is " + 0 + "; Output is "
                + solution.maxNumberOfEngineeringTeam(3, 5, new int[] { 34, 5, 72, 48, 15, 2
                }));
        System.out.println("Expected answer is " + 3 + "; Output is "
                + solution.maxNumberOfEngineeringTeam(3, 25,
                        new int[] { 1, 7, 18, 32, 65, 72, 90, 98, 100, 113, 146 }));
    }

    // 2
    private static void countPowerForSerives(Solution solution) {

    }

    // 3
    private static void shipmentImbalanceII(Solution solution) {

    }

    private static void badNumbers(Solution solution) {
        System.out.println("Expected answer is " + 14 + "; Output is "
                + solution.badNumbers(new int[] { 37, 7, 22, 15, 49, 60 }, 3, 48));
        System.out.println("Expected answer is " + 14 + "; Output is "
                + solution.badNumbers(new int[] { 37, 7, 22, 15, 49, 60 }, 3, 65));
    }

    private static void maxDeviation(Solution solution) {
        System.out.println("Expected answer is " + 2 + "; Output is "
                + solution.maxDeviation("abacccabab"));
        System.out.println("Expected answer is " + 3 + "; Output is "
                + solution.maxDeviation("abbbcacbcdce"));
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        // campingDay(solution);
        // armorGameTester(solution);
        // groupMovieTester(solution);
        // pascalEncode(solution);
        // maxQuality(solution);
        // decreasingRatingTester(solution);
        // minMovesToGroupOneAndZeroTester(solution);
        // maxDeviation(solution);
        // findMaxSustainableClusterSizeTester(solution);
        // subarrayImbalance(solution);
        // shipmentImbalance(solution);
        // shipmentImbalanceII(solution);
        // grayScale(solution);
        // separatePrimesTester(solution);
        // remove5Tester(solution);
        // partitionBracketArrayTester(solution);
        // kthBestCombo(solution);
        // maxAggTemperature(solution);
        // minCostFullLoadTruck(solution);
        // removeInvalidParenthese(solution);
        // threePages(solution);
        // discountTag(solution);
        // maxSegmentProfit(solution);
        // mergePackage(solution);
        // wifiRouter(solution);
        // minimizeMemory(solution);
        // findVowelPasswordStrength(solution);
        // sortOrder(solution);
        // longestOneProudctSubarray(solution);
        // validGroupon(solution);
        // maxNumberOfEngineeringTeam(solution);
        // countPowerForSerives(solution);
        // badNumbers(solution);
    }
}
