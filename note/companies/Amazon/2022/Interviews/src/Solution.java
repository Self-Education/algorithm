package Interviews.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {


    /*
     * given a int array, find array of index, that
     * day[i-k]>=day[i-k+1]>=....>=day[i-1]>=day[i]<=day[i+1]<=....<=day[i+k-1]<=day[i+k]
     */
    public List<Integer> campingDay(int[] temps, int k) {
        int m = temps.length;
        int[] left = new int[m], right = new int[m];
        left[0] = 1;
        right[m - 1] = 1;
        List<Integer> ans = new LinkedList<>();
        for (int i = 1; i < m; i++) {
            if (temps[i] <= temps[i - 1]) {
                left[i] = 1 + left[i - 1];
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            if (temps[i] <= temps[i + 1])
                right[i] = 1 + right[i + 1];
        }

        for (int i = 0; i < m; i++) {
            if (left[i] >= k + 1 && right[i] >= k + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    /*
     * given an array power, at ith step, the player health will be deducted by power[i] the player
     * has one chance to use armor which prevent the damgage max(armor, power[i]); find the min
     * start health to finish the game (health must be >= 1 at all time)
     */
    public int armorGame(int[] power, int armor) {
        return armorGameHelper(power, armor, 0, 1);
    }

    private int armorGameHelper(int[] power, int armor, int i, int k) {
        if (i == power.length)
            return 1;
        // do not use armor
        int case1 = power[i] + armorGameHelper(power, armor, i + 1, k);
        // use armor
        int case2 = Integer.MAX_VALUE;
        if (k >= 1) {
            case2 = armorGameHelper(power, armor, i + 1, k - 1)
                    + (power[i] > armor ? power[i] - armor : 0);
        }

        return Math.max(1, Math.min(case1, case2));
    }
    /*
     * given an array find all subarrays that is decreasing (including length 1)
     */

    public int decreasingRating(int[] ratings) {
        int count = 0, m = ratings.length;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        count += dp[0];
        for (int i = 1; i < m; i++) {
            if (ratings[i] < ratings[i - 1])
                dp[i] += dp[i - 1];
            count += dp[i];
        }
        return count;
    }

    /*
     * Given an array containing only 0 and 1 as its elements. We have to sort the array in such a
     * manner that all the ones are grouped together and all the zeros are grouped together. The
     * group of ones can be either at the start of the array or at the end of the array. The
     * constraint while sorting is that every one/zero can be swapped only with its adjacent
     * zero/one. Find the minimum number of moves to sort the array as per the description.
     * 
     * [1,0,0,1,0,1,1,0,0,1] ->[1,1,1,1,1,0,0,0,0,0] 2 + 3 + 3 + 5 = 13 ->[0,0,0,0,0,1,1,1,1,1] 2 +
     * 2 + 3 + 5 = 12
     * 
     */
    public int minMovesToGroupOneAndZero(int[] arr) {
        List<Integer> ones = new ArrayList<>();
        int m = arr.length;
        for (int i = 0; i < m; i++) {
            if (arr[i] == 1)
                ones.add(i);
        }
        // if all left
        int case1 = 0;
        for (int i = 0; i < ones.size(); i++)
            case1 += ones.get(i) - i;

        // if all right
        int case2 = 0;
        for (int i = ones.size() - 1, j = m - 1; i >= 0; i--, j--)
            case2 += j - ones.get(i);
        return Math.min(case1, case2);
    }

    /*
     * move prime to the left and non-prime to the right
     */
    public int[] separatePrimes(int[] arr) {

    }

    /*
     * given a integer, remove one 5 to get max
     */
    public int remove5(int a) {

    }

    /*
     * given a array, group them into different groups in which difference of any two numbers is <=
     * k, find the min number of groups
     */
    public int groupMovie(int[] movies) {

    }

    /*
     * give a strin array, includes [, ], (, ), find number of ways to parition it into valid
     * subarray
     */
}
