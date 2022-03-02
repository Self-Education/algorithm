package Interviews.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    /*
     * Good camping day given a int array and int k, find array of index, that
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
     * First Blood given an array power, at ith step, the player health will be
     * deducted by power[i]
     * the player has one chance to use armor which prevent the damgage max(armor,
     * power[i]); find
     * the min start health to finish the game (health must be >= 1 at all time)
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
     * Decreasing Ratings given an array find all subarrays that is decreasing
     * (including length 1)
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
     * Min Swap to group 1s and 0s Given an array containing only 0 and 1 as its
     * elements. We have
     * to sort the array in such a manner that all the ones are grouped together and
     * all the zeros
     * are grouped together. The group of ones can be either at the start of the
     * array or at the end
     * of the array. The constraint while sorting is that every one/zero can be
     * swapped only with
     * its adjacent zero/one. Find the minimum number of moves to sort the array as
     * per the
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
        return -1;
    }

    /*
     * Max Length of Valid Server Cluster e.g. bootingPower = [3, 6, 1, 3, 4]
     * processingPower = [2,
     * 1, 3, 4, 5] i j powerMax = 25
     * 
     * sum: 13 deque: 4(5) cost: 32 maxLen: 3
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
     * move prime to the left and non-prime to the right [1, 2, 4, 8, 9, 11, 15, 17,
     * 27, 25, 28]
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
     * given a integer, remove one 5 to get max 15958
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
     * Group Moive; given a array, group them into different groups in which
     * difference of any two
     * numbers is <= k, find the min number of groups
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
     * Pascal Encoding
     * Given an int array, each round sum adjacent number % 10, until only two
     * numbers left
     */
    public int pascalEncode(String s) {
        int m = s.length();
        if (m == 1)
            return Integer.parseInt(s);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(s.charAt(i) - '0');
        }

        while (list.size() > 2) {
            List<Integer> level = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                level.add((list.get(i - 1) + list.get(i)) % 10);
            }
            list = new ArrayList<>(level);
        }
        System.out.println(list);
        int ans = list.get(0) * 10 + list.get(1);
        return ans;
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

    /*
     * given array in which elements are either 1 or -1, find the length of the
     * longest subarray
     * that has product as 1
     */
    public int longestOneProudctSubarray(int[] arr) {
        int m = arr.length, maxLen = 0;
        int[] pos = new int[m], neg = new int[m];
        if (arr[0] == 1) {
            pos[0] = 1;
        } else {
            neg[0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (arr[i] == 1) {
                pos[i] = 1 + pos[i - 1];
                neg[i] = neg[i - 1] > 0 ? 1 + neg[i - 1] : 0;
            } else {
                pos[i] = neg[i - 1] > 0 ? 1 + neg[i - 1] : 0;
                neg[i] = 1 + pos[i - 1];
            }
            maxLen = Math.max(maxLen, pos[i]);
        }
        return maxLen;
    }

    /*
     * merge package
     */
    public int mergePackage(int[] arr) {
        int m = arr.length, prev = arr[m - 1], max = prev;
        for (int i = m - 2; i >= 0; i--) {
            if (arr[i] < prev) {
                prev += arr[i];

            } else {
                prev = arr[i];
            }
            max = Math.max(prev, max);
        }
        return max;
    }

    /*
     * kth best combo Constraints 1 <= n <= 10^5 10^9 <= array[i] <= 10^9 1 <= k <=
     * min(2000,2^n)
     * cannot use backtrack directly, the max len of subset is 2000 wich 2^11 so we
     * only need to
     * find subset from top 11 largest number
     */
    public List<Integer> kthBestCombo(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr.length;
        List<Integer> nums = new ArrayList<>();
        for (int i = m - 1; i > m - 1 - k; i--)
            nums.add(arr[i]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        kthBestComboHelper(queue, nums, k, 0, 0);
        List<Integer> ans = new LinkedList<>();
        while (!queue.isEmpty())
            ans.add(queue.poll());
        Collections.reverse(ans);
        return ans;
    }

    private void kthBestComboHelper(PriorityQueue<Integer> queue, List<Integer> arr, int k,
            int index, int sum) {

        queue.offer(sum);
        if (queue.size() > k) {
            queue.poll();
        }

        for (int i = index; i < arr.size(); i++) {
            kthBestComboHelper(queue, arr, k, i + 1, sum + arr.get(i));
        }
    }

    /*
     * Wifi Router
     */
    public int wifiRouter(int[] buildingCount, int[] routerLocation, int[] routerRange) {
        int m = buildingCount.length, n = routerLocation.length;
        int[] cache = new int[m];
        for (int i = 0; i < n; i++) {
            int left = routerLocation[i] - routerRange[i] - 1;
            int right = routerLocation[i] + routerRange[i];
            cache[Math.max(0, left)] += 1;
            if (right < m)
                cache[right] -= 1;
            System.out.println(Arrays.toString(cache));
        }

        int sum = 0, count = 0;
        for (int i = 0; i < m; i++) {
            sum += cache[i];
            if (sum >= buildingCount[i])
                count++;
        }
        return count;
    }

    /*
     * parcels and trucks
     * given an array indicates the cost of parcels (int [] parcels) already
     * in the truck, try to add more parcels from 1 to n (parcels in the list
     * cannot be used) into the truck to minimize the cost and also full load truck
     * (capacity k)
     */
    public int minCostFullLoadTruck(int[] parcels, int k) {
        Set<Integer> set = new HashSet<>();
        k -= parcels.length;
        int sum = 0;
        for (int p : parcels)
            set.add(p);
        for (int i = 1; i <= (int) 1e5 && k > 0; i++) {
            if (!set.contains(i)) {
                sum += i;
                k--;
            }
        }
        return sum;
    }

    /*
     * minimize memory given array indicates memory used for each process, tyr to
     * delete a
     * contiguous segment of process to minimize the total memory: e.g. [10,4,8,1],
     * k = 2; delete
     * [10, 4], min memory is 9
     * 
     */
    public int minimizeMemory(int[] process, int k) {
        int total = 0, sum = 0, max = 0, m = process.length;
        for (int i = 0, j = 0; j < m; j++) {
            total += process[j];
            sum += process[j];
            if (j > k - 1) {
                sum -= process[i++];
            }

            if (j >= k - 1) {
                max = Math.max(max, sum);
            }
        }

        return total - max;
    }

    /*
     * Vowel password strength, the password strength increases by one if there is a
     * non-overlapped
     * substring has at least one Vowel and one Cosonant, find the password strength
     */
    public int findVowelPasswordStrength(String s) {
        int m = s.length(), ans = 0, count1 = 0, count2 = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                count1++;
            } else {
                count2++;
            }
            if (count1 >= 1 && count2 >= 1) {
                ans++;
                count1 = 0;
                count2 = 0;
            }
        }
        return ans;
    }

    /*
     * Sort order
     */
    public List<String> sortOrder(List<String> orders) {
        List<String> prime = new LinkedList<>();
        List<String> nonPrime = new LinkedList<>();
        for (String order : orders) {
            if (isPrimeOrder(order))
                prime.add(order);
            else
                nonPrime.add(order);
        }
        Collections.sort(prime, (a, b) -> {
            String[] aa = a.split(" ", 2);
            String[] bb = b.split(" ", 2);
            if (!aa[0].equals(bb[0])) {
                return aa[0].compareTo(bb[0]);
            } else {
                return aa[1].compareTo(bb[0]);
            }
        });
        for (String order : nonPrime) {
            prime.add(order);
        }
        return prime;
    }

    private boolean isPrimeOrder(String order) {
        for (char c : order.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }

    /*
     * max segmented profit
     */
    public long maxSegmentProfit(int[] profits, int k) {
        int m = profits.length; // m is always even
        int sum = 0;
        long max = 0;
        for (int i = 0, j = 0; j < m; j++) {
            sum += profits[j] + profits[(j + m / 2) % m];
            if (j > k - 1) {
                sum -= profits[i];
                sum -= profits[(i + m / 2) % m];
                i++;
            }

            if (j >= k - 1) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /*
     * Discount Tag
     */
    public int discountTag(String[][] products, String[][] discounts) {
        int m = products.length, n = discounts.length;
        Map<String, String[]> map = new HashMap<>();
        for (String[] d : discounts) {
            map.put(d[0], d);
        }
        int sum = 0;
        for (String[] p : products) {
            int price = Integer.parseInt(p[0]);
            int minPrice = price;
            for (int i = 1; i < p.length; i++) {
                String tag = p[i];
                if (tag.equals("EMPTY"))
                    continue;
                if (!map.containsKey(tag))
                    continue;
                String type = map.get(tag)[1];
                int newPrice = 0;
                if (type.equals("0")) {
                    newPrice = Integer.parseInt(map.get(tag)[2]);
                } else if (type.equals("1")) {
                    newPrice = (int) Math.round((double) price * (1 - Double.parseDouble(map.get(tag)[2]) / 100));
                } else {
                    newPrice = price - Integer.parseInt(map.get(tag)[2]);
                }
                minPrice = Math.min(minPrice, newPrice);
            }
            sum += minPrice;
        }
        return sum;
    }

}
