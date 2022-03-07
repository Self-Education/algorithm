package Interviews.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
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
     * Pascal Encoding Given an int array, each round sum adjacent number % 10,
     * until only two
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
        int ans = list.get(0) * 10 + list.get(1);
        return ans;
    }

    /*
     * Max Quality Greedy, we try to expose larger number as median
     */
    public int maxQuality(int[] packets, int n) {
        int ans = 0, m = packets.length;
        Arrays.sort(packets);
        int i = 0;
        for (i = m - 1; i >= 0 && n > 1; i--, n--) {
            ans += packets[i];
        }
        int len = i + 1;
        if (len % 2 == 0) {
            ans += (int) Math.ceil((double) (packets[len / 2 - 1] + packets[len / 2]) / 2);
        } else {
            ans += packets[len / 2];
        }
        return ans;
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

        // for (int i = 0, j = 0; j < m; j++) {
        // if (j == 0) {
        // count++;
        // continue;
        // }
        // if (ratings[j] >= ratings[j - 1]) {
        // i = j;
        // }
        // count += j - i + 1;
        // }
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
     * Max Deviation try out all pairs of maxFreq and minFreq chars, key thing is
     * that
     * "ababbbbcaac", even though we will pick maxFreq = 'a' and minFreq = 'c' in
     * fact, the maxFreq
     * = 'b', but it wont affect result since we will try maxFreq = 'b' in one round
     */

    public int maxDeviation(String s) {
        // pass
        int m = s.length(), ans = 0;
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (c1 == c2)
                    continue;
                List<Integer> list = new ArrayList<>();
                for (char c : s.toCharArray()) {
                    if (c == c1) {
                        // combine consectuive c1, to avoid the case that only c1
                        // in the string, we need two different chars
                        if (list.size() > 0 && list.get(list.size() - 1) != -1) {
                            list.set(list.size() - 1, list.get(list.size() - 1) + 1);
                        } else {
                            list.add(1);
                        }
                    } else if (c == c2) {
                        list.add(-1);
                    }
                }
                ans = Math.max(ans, maxDeviationHelper(list));
            }
        }
        return ans;
    }

    private int maxDeviationHelper(List<Integer> list) {
        int max = 0, sum = 0, charCount = 0;// count number of different chars
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            charCount++;

            if (sum < 0) {
                charCount = 0;
                sum = 0;
            } else if (charCount > 1) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /*
     * Max Length of Valid Server Cluster e.g. bootingPower = [3, 6, 1, 3, 4]
     * processingPower = [2,
     * 1, 3, 4, 5] max power consuption: maxBootingPower[i:j] +
     * sumProcessingPower[i:j] * (j - i +
     * 1)
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
     * Subarray Imbalance/Student Ranks
     * 
     * x x x l x x i x x x r x x x A[l + 1] ocurrs r - i times A[l + 2] occurs 2 *
     * (r - i) times
     * 
     * 
     * A[i] occurs (i - l) * (r - i);
     */
    public int subarrayImbalance(int[] arr) {
        return -1;
    }

    /*
     * Shipment Imbalance sum(max) - sum(min)
     */
    public long shipmentImbalance(int[] nums) {
        int m = nums.length;

        // get the next smaller
        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[m];
        Arrays.fill(nextSmaller, m);
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }
        // get the prev smaller
        stack = new Stack<>();
        int[] prevSmaller = new int[m];
        Arrays.fill(prevSmaller, -1);
        for (int i = m - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                prevSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        // get next greater
        stack = new Stack<>();
        int[] nextGreater = new int[m];
        Arrays.fill(nextGreater, m);
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                nextGreater[stack.pop()] = i;
            }
            stack.push(i);
        }

        // get prev greater
        stack = new Stack<>();
        int[] prevGreater = new int[m];
        Arrays.fill(prevGreater, -1);
        for (int i = m - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                prevGreater[stack.pop()] = i;
            }
            stack.push(i);
        }

        long sum = 0L;
        for (int i = 0; i < m; i++) {
            sum += (long) nums[i] * (i - prevGreater[i]) * (nextGreater[i] - i)
                    - (long) nums[i] * (i - prevSmaller[i]) * (nextSmaller[i] - i);
        }

        return sum;
    }

    /*
     * shipment imbalance 2 Given an array find number of subarray in which max -
     * min <= k x x l x x
     * i x x x j x x x ->
     */
    public int shipmentImbalanceII(int[] parcels, int k) {
        int m = parcels.length;
        // find the prev smaller
        Deque<Integer> maxQue = new LinkedList<>();
        Deque<Integer> minQue = new LinkedList<>();
        int diff = 0, count = 0;
        for (int i = 0, j = 0; j < m; j++) {
            // update max
            while (!maxQue.isEmpty() && parcels[maxQue.peek()] <= parcels[j]) {
                maxQue.pollLast();
            }

            // update min
            while (!minQue.isEmpty() && parcels[minQue.peek()] >= parcels[j]) {
                minQue.pollLast();
            }
            maxQue.offerLast(j);
            minQue.offerLast(j);
            diff = parcels[maxQue.peekFirst()] - parcels[minQue.peekFirst()];
            while (i < j && diff > k) {
                if (!maxQue.isEmpty() && maxQue.peekFirst() == i) {
                    maxQue.pollFirst();
                }
                if (!minQue.isEmpty() && minQue.peekFirst() == i) {
                    minQue.pollFirst();
                }
                i++;
                diff = parcels[maxQue.peekFirst()] - parcels[minQue.peekFirst()];
            }
            count += j - i + 1;
        }
        return count;
    }

    /*
     * Gray Scale Given a 2D array, only inlcue value 0, 1, the gray scale of a cell
     * [i,j] is
     * sum(row[i]) + sum(col[j]), find the the cell with max gray scale;
     */
    public int grayScale(int[][] grid) {
        int m = grid.length, n = grid.length;
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < m; i++) {
            int r = 0;
            for (int j = 0; j < n; j++) {
                r += grid[i][j] == 0 ? 1 : -1;
            }
            row[i] = r;
        }

        for (int j = 0; j < n; j++) {
            int c = 0;
            for (int i = 0; i < m; i++) {
                c += grid[i][j] == 0 ? 1 : -1;
            }
            col[j] = c;
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, row[i] + col[j]);
            }
        }
        return max;
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
     * Max Aggregate Temperature
     */
    public int maxAggTemperature(int[] temps) {
        int m = temps.length;
        int[] prefixSum = new int[m];
        prefixSum[0] = temps[0];
        for (int i = 1; i < m; i++)
            prefixSum[i] = prefixSum[i - 1] + temps[i];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int left = prefixSum[i];
            int right = i - 1 < 0 ? prefixSum[m - 1] : prefixSum[m - 1] - prefixSum[i - 1];
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }

    /*
     * parcels and trucks given an array indicates the cost of parcels (int []
     * parcels) already in
     * the truck, try to add more parcels from 1 to n (parcels in the list cannot be
     * used) into the
     * truck to minimize the cost and also full load truck (capacity k)
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
     * Rmove invalid parenthese a(b))c(d
     */
    public String removeInvalidParenthese(String s) {
        Stack<Integer> stack = new Stack<>();
        int m = s.length();
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        while (!stack.isEmpty())
            set.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /*
     * Kindle non-adjacent pages
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
                    newPrice = (int) Math.round(
                            (double) price * (1 - Double.parseDouble(map.get(tag)[2]) / 100));
                } else {
                    newPrice = price - Integer.parseInt(map.get(tag)[2]);
                }
                minPrice = Math.min(minPrice, newPrice);
            }
            sum += minPrice;
        }
        return sum;
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
     * merge package Given int[] packageWeight, we can combine ith and i + 1th
     * package only if
     * packageWeight[i] < pacakgeWeight[i + 1], we can merge until there are two
     * packages left, find
     * the heaviest pacakge after merging
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
     * minimize memory given array indicates memory used for each process, try to
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
     * Valid Groupon There are 3 rules for a valid string:
     * 
     * An empty string is valid You can add same character to a valid string X, and
     * create another
     * valid string yXy You can concatenate two valid strings X and Y, so XY will
     * also be valid. Ex:
     * vv, xbbx, bbccdd, xyffyxdd are all valid.
     */
    public int[] validGroupon(String[] groupons) {
        int m = groupons.length;
        int[] ans = new int[m];

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            stack = new Stack<>();
            for (char c : groupons[i].toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            ans[i] = stack.size() == 0 ? 1 : 0;
        }
        return ans;
    }

    /*
     * Max Number of engineering team Greedy
     */
    public int maxNumberOfEngineeringTeam(int teamSize, int maxDiff, int[] skills) {
        int ans = 0, m = skills.length;
        Arrays.sort(skills);
        int i = 0;
        while (i <= m - teamSize) {
            if (skills[i + teamSize - 1] - skills[i] <= maxDiff) {
                ans++;
                i = i + teamSize;
            } else {
                i++;
            }
        }
        return ans;
    }

    /*
     * Count Power for services
     */
    public int countPowerForSerives(int[] arr) {
        return -1;
    }

    /* bad numbers */
    public int badNumbers(int[] arr, int low, int high) {
        Arrays.sort(arr);
        // find the lower bound
        int m = arr.length, i = 0, maxGap = 0;
        while (i < m && arr[i] < low)
            i++;
        if (i == m)
            return 0;
        maxGap = Math.max(maxGap, arr[i++] - low);

        for (; i < m && arr[i] <= high; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                maxGap = Math.max(maxGap, arr[i] - 1 - (arr[i - 1] + 1) + 1);
            }
        }
        if (i == m) {
            maxGap = Math.max(maxGap, high - arr[i - 1]);

        } else {
            maxGap = Math.max(maxGap, high - arr[i - 1]);
        }
        return maxGap;
    }

    /*
     * Flip coin h t t t h h t t h t t -> t: dp[i - 1]; -> h: 1 + count(t); h -> t:
     * 1 + dp[i - 1];
     * h: count(t);
     */
    public int flipCoin(String coins) {
        int m = coins.length(), tCount = 0;
        int[] dp = new int[m];
        for (int i = 1; i < m; i++) {
            if (coins.charAt(i) == 'T') {
                dp[i] = Math.min(dp[i - 1], 1 + tCount);
                tCount++;
            } else {
                dp[i] = Math.min(1 + dp[i - 1], tCount);
            }
        }
        return dp[m - 1];
    }

    /* package shipment system */
    public List<List<String>> shipPackages(List<String[]> queries) {
        List<List<String>> ans = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        for (String[] q : queries) {
            String action = q[0];
            String id = q[1];
            if (action.equals("insert")) {
                queue.offer(id);
            } else {
                List<String> out = new LinkedList<>();
                if (queue.size() >= 3) {
                    while (!queue.isEmpty())
                        out.add(queue.poll());
                } else {
                    out.add("N/A");
                }
                ans.add(out);
            }
        }
        return ans;
    }

    /*
     * utilization optimization <= target and as close as possible
     */
    public List<int[]> OptimizeUtilization(List<int[]> A, List<int[]> B,
            int target) {
        List<int[]> ans = new LinkedList<>();
        Collections.sort(A, (a, b) -> a[1] - b[1]);
        Collections.sort(B, (a, b) -> a[1] - b[1]);
        int m = A.size(), n = B.size(), i = 0, j = n - 1, max = -1;
        while (i < m && j >= 0) {
            int a = A.get(i)[1];
            int b = B.get(j)[1];
            int sum = a + b;
            if (sum <= target) {
                if (sum >= max) {
                    if (sum > max) {
                        ans.clear();
                        max = sum;
                    }
                    ans.add(new int[] { A.get(i)[0], B.get(j)[0] });
                    // since we are going to increment i, we need to
                    int k = j - 1;
                    while (k >= 0 && B.get(k)[1] == B.get(k + 1)[1]) {
                        ans.add(new int[] { A.get(i)[0], B.get(k)[0] });
                        k--;
                    }
                }
                i++;

            } else {
                j--;
            }

        }
        return ans;
    }

    /* Wheel cipher */
    public String wheelCipher(String s, int k) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            ca[i] = (char) ((ca[i] + 'A' - k + 26) % 26 + 'A');
        }
        return String.valueOf(ca);
    }

    /* Decode String */
    public int[] decodeString(String s) {
        int[] ans = new int[26];
        int m = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else if (c == '#') {
                int a = stack.pop();
                int b = stack.pop();
                int num = b * 10 + a;
                stack.push(num);
            } else {
                int j = s.indexOf(")", i + 1);
                int freq = Integer.parseInt(s.substring(i + 1, j));
                ans[stack.pop() - 1] += freq;
                i = j;
            }
        }
        while (!stack.isEmpty()) {
            ans[stack.pop() - 1] += 1;
        }
        return ans;
    }

    /*
     * Tree Heights observation: any element should be in the range of [min, max];
     * if element after
     * operations goes below the min, that means all other numbers decreasing, in
     * order to make min
     * operation, we should increase smaller numbers and decreasing larger number,
     * 双向奔赴 dp[i][j]:
     * min operation to make H[:i] to be sorted when turn ith number into j
     */
    public int treeHeights(int[] H) {
        int m = H.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int h : H) {
            min = Math.min(min, h);
            max = Math.max(max, h);
        }

        int[][] dp = new int[m][max + 1];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        for (int j = min; j <= max; j++) {
            dp[0][j] = Math.abs(j - H[0]);
        }

        for (int i = 1; i < m; i++) {
            int prevMin = Integer.MAX_VALUE;
            for (int j = min + i; j <= max; j++) {
                // if set H[i] to j, then all previous element can be any value < j
                prevMin = Math.min(prevMin, dp[i - 1][j - 1]);
                dp[i][j] = prevMin + Math.abs(j - H[i]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = min; j <= max; j++) {
            ans = Math.min(ans, dp[m - 1][j]);
        }
        return ans;
    }

    /* split int into primes */
    public int splitIntToPrimes(String s) {
        return splitIntToPrimesHelper(s, 0);
    }

    private int splitIntToPrimesHelper(String s, int index) {
        if (index == s.length())
            return 1;
        int res = 0;
        if (s.charAt(index) == '0')
            return 0;
        for (int i = index; i < s.length(); i++) {
            if (isPrime(s.substring(index, i + 1))) {
                res += splitIntToPrimesHelper(s, i + 1);
                // System.out.println(res);
            }
        }
        return res;
    }

    private boolean isPrime(String s) {
        int num = Integer.parseInt(s);
        if (num < 2)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;
        for (int i = 3; i * i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    /* Number game */
    public int numberGameGCD(int[] nums) {
        int m = nums.length;
        int[][] memo = new int[m][(1 << 14) + 1];
        return numberGameGCDHelper(nums, 1, 0, m, memo);
    }

    private int numberGameGCDHelper(int[] nums, int count, int state, int m, int[][] memo) {
        if (count > m / 2)
            return 0;
        if (memo[count][state] != 0)
            return memo[count][state];
        int max = 0;
        for (int i = 0; i < m; i++) {
            if ((state >> i & 1) == 1)
                continue;
            int newState = state | (1 << i);
            for (int j = i + 1; j < m; j++) {
                if ((newState >> j & 1) == 1)
                    continue;
                max = Math.max(max, count * gcd(nums[i], nums[j])
                        + numberGameGCDHelper(nums, count + 1, newState | (1 << j), m, memo));
            }
        }
        return memo[count][state] = max;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /*
     * Arrange keypad given a string, arrange letters on the keypad, find the min
     * click to type the
     * string
     */
    public int arrangeKeypad(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        for (char key : map.keySet())
            queue.offer(key);
        int count = 0, click = 1, ans = 0;
        while (!queue.isEmpty()) {
            count++;
            ans += map.get(queue.poll()) * click;
            if (count >= 9) {
                click++;
                count = 0;
            }
        }
        return ans;
    }

    /* max cumulative observable sum */
    public int maxCumulativeObservableSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, m = arr.length, sum = 0, max = 0;
        for (int i = 0, j = 0; j < m; j++) {
            sum += arr[j];
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            if (map.get(arr[j]) == 1)
                count++;

            while (i < j && (j - i + 1 > k || count != j - i + 1)) {
                sum -= arr[i];
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0)
                    count--;
                i++;
            }
            if (j - i + 1 == k)
                max = Math.max(max, sum);
        }
        return max;
    }

    /* common prefix */
    public int commonPrefix(String s) {
        char first = s.charAt(0);
        int m = s.length(), ans = 0;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == first) {
                ans += commonPrefixHelper(s, i);
            }
        }
        return ans;
    }

    private int commonPrefixHelper(String s, int start) {
        int count = 0;
        int i = 0;
        while (start < s.length() && s.charAt(i) == s.charAt(start)) {
            start++;
            i++;
            count++;
        }
        return count;
    }

    /* number of subarray with at most k odds */
    public int subarrayWithAtMostKOdds(int[] arr, int k) {
        Set<String> set = new HashSet<>();
        int m = arr.length, count = 0;
        for (int i = 0, j = 0; j < m; j++) {
            if (arr[j] % 2 == 1)
                count++;
            while (i < j && count > k) {
                if (arr[i] % 2 == 1)
                    count--;
                i++;
            }
            // need to deduplicate
            subarrayWithAtMostKOddsHelper(set, arr, i, j);
        }
        return set.size();
    }

    private void subarrayWithAtMostKOddsHelper(Set<String> set, int[] arr, int l, int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = l; i <= r; i++) {
            sb = new StringBuilder();
            for (int j = i; j <= r; j++) {
                sb.append(arr[j]).append(",");
            }
            set.add(sb.toString());
        }
    }

    /* count AZ */
    public int countAZ(String s) {
        int countA = 0, countZ = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                countA++;
            } else if (c == 'Z') {
                countZ++;
            }
        }
        if (countA > countZ) {
            countZ++;
            s += "Z";
        } else {
            countA++;
            s = "A" + s;
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                ans += countZ;
            } else if (c == 'Z') {
                countZ--;
            }
        }
        return ans;
    }

    /* deliver boxes */
    public int deliverBoxes(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr)
            map.put(a, map.getOrDefault(a, 0) + 1);
        int count = 0;
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq < 2)
                return -1;
            while (freq > 4) {
                freq -= 3;
                count++;
            }
            if (freq <= 3) {
                count++;
            } else {
                count += 1;
            }
        }
        return count;
    }

}
