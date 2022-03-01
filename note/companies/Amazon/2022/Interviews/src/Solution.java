package Interviews.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

public class Solution {

    /*
     * Good camping day
     * given a int array, find array of index, that
     * day[i-k]>=day[i-k+1]>=....>=day[i-1]>=day[i]<=day[i+1]<=....<=day[i+k-1]<=day
     * [i+k]
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
     * First Blood
     * given an array power, at ith step, the player health will be deducted by
     * power[i] the player
     * has one chance to use armor which prevent the damgage max(armor, power[i]);
     * find the min
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
     * Decreasing Ratings
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
     * Min Swap to group 1s and 0s
     * Given an array containing only 0 and 1 as its elements. We have to sort the
     * array in such a
     * manner that all the ones are grouped together and all the zeros are grouped
     * together. The
     * group of ones can be either at the start of the array or at the end of the
     * array. The
     * constraint while sorting is that every one/zero can be swapped only with its
     * adjacent
     * zero/one. Find the minimum number of moves to sort the array as per the
     * description.
     * 
     * [1,0,0,1,0,1,1,0,0,1] ->[1,1,1,1,1,0,0,0,0,0] 2 + 3 + 3 + 5 = 13
     * ->[0,0,0,0,0,1,1,1,1,1] 2 +
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
     * Max Deviation
     */

    public int maxDeviation(int[] arr) {
        // pass
    }

    /*
     * Max Length of Valid Server Cluster
     * e.g.
     * bootingPower = [3, 6, 1, 3, 4]
     * processingPower = [2, 1, 3, 4, 5]
     * i j
     * powerMax = 25
     * 
     * sum: 13
     * deque: 4(5)
     * cost: 32
     * maxLen: 3
     */
    public int findMaxSustainableClusterSize(int[] processingPower, int[] bootPower, int powerMax) {
        Deque<Integer> deque = new LinkedList<>();
        int m = processingPower.length;
        int sum = 0, cost = 0, maxLen = 0;
        for (int i = 0, j = 0; j < m; j++) {
            sum += processingPower[j];
            // remove unused max candiates
            while (!deque.isEmpty() && bootPower[deque.peekLast()] <= bootPower[j]) {
                deque.pollLast();
            }
            deque.offerLast(j);
            cost = bootPower[deque.peekFirst()] + sum * (j - i + 1);
            while (cost >= powerMax) {
                sum -= processingPower[i];
                if (!deque.isEmpty() && deque.peekFirst() == i)
                    deque.pollFirst();
                i++;
                cost = bootPower[deque.peekFirst()] + sum * (j - i + 1);
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    /*
     * move prime to the left and non-prime to the right
     * [1, 2, 4, 8, 9, 11, 15, 17, 27, 25, 28]
     */
    public List<List<Integer>> separatePrimes(int[] arr) {
        Set<Integer> primes = new HashSet<>();
        Set<Integer> nonPrimes = new HashSet<>();
        int max = 0;
        for (int a : arr) {
            if (a == 1) {
                nonPrimes.add(a);
            } else {
                primes.add(a);
            }
            max = Math.max(max, a);
        }
        int[] flag = new int[max + 1];
        int i = 2;
        while (i < max) {
            for (int j = i * i; j <= max; j += i) {
                flag[j] = 1;
                if (primes.contains(j)) {
                    primes.remove(j);
                    nonPrimes.add(j);
                }
            }
            i++;
            while (i <= max && flag[i] == 1)
                i++;
        }
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        for (int s : primes)
            left.add(s);
        for (int s : nonPrimes)
            right.add(s);
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(left);
        ans.add(right);
        return ans;
    }

    /*
     * given a integer, remove one 5 to get max
     * 15958
     */
    public int remove5(int a) {
        String s = Integer.toString(a);
        int m = s.length();
        for (int i = 0; i < m - 1; i++) {
            if (s.charAt(i) == '5' && s.charAt(i + 1) > s.charAt(i)) {
                return Integer.parseInt(s.substring(0, i) + s.substring(i + 1));
            }
        }
        // no larger number following 5
        for (int i = m - 1; i >= 0; i--) {
            if (s.charAt(i) == '5') {
                return Integer.parseInt(s.substring(0, i) + s.substring(i + 1));
            }
        }
        return -1;
    }

    /*
     * given a array, group them into different groups in which difference of any
     * two numbers is <= k, find the min number of groups
     */
    public int groupMovie(int[] movies, int k) {
        Arrays.sort(movies);
        int count = 0;
        for (int i = 0, j = 1; j < movies.length; j++) {
            if (movies[j] - movies[i] > k) {
                count++;
                i = j;
            }
        }
        count++;
        return count;
    }

    /*
     * give a strin array, includes [, ], (, ), find number of ways to parition it
     * into valid
     * subarray
     */
    public int partitionBracketArray(String s) {
        int count1 = 0, count2 = 0, count3 = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                count1++;
            } else if (c == ']') {
                count1--;
            } else if (c == '?') {
                count3++;
            } else if (c == '(') {
                count2++;
            } else {
                count2--;
            }
            if (Math.abs(count1) + Math.abs(count2) == count3)
                res++;
        }
        return res;
    }
    /*
     * 0 1 0 0 1
     * 
     * 010, 101
     * 
     * x 1 x x x 1 x x x x 1 x x x
     * 
     */

    public long threePages(String book) {
        int m = book.length();
        int[] zeroLeft = new int[m], zeroRight = new int[m];
        int[] oneLeft = new int[m], oneRight = new int[m];
        if (book.charAt(0) == '0') {
            zeroLeft[0] = 1;
        } else {
            oneLeft[0] = 1;
        }

        if (book.charAt(m - 1) == '0') {
            zeroRight[m - 1] = 1;
        } else {
            oneRight[m - 1] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (book.charAt(i) == '0') {
                zeroLeft[i] = zeroLeft[i - 1] + 1;
                oneLeft[i] = oneLeft[i - 1];
            } else {
                zeroLeft[i] = zeroLeft[i - 1];
                oneLeft[i] = oneLeft[i - 1] + 1;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            if (book.charAt(i) == '0') {
                zeroRight[i] = zeroRight[i + 1] + 1;
                oneRight[i] = oneRight[i + 1];
            } else {
                zeroRight[i] = zeroRight[i + 1];
                oneRight[i] = oneRight[i + 1] + 1;
            }
        }
        int count = 0;
        // handle 010
        for (int i = 0; i < m; i++) {
            if (book.charAt(i) == '1') {
                count += zeroLeft[i] * zeroRight[i];
            }

            if (book.charAt(i) == '0') {
                count += oneLeft[i] * oneRight[i];
            }
        }
        return count;
    }
}
