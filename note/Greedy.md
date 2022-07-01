# Greedy

1. [316. Remove Duplicate Letters -- Medium](https://leetcode.com/problems/remove-duplicate-letters/)
2. [45. Jump Game II -- Medium](https://leetcode.com/problems/jump-game-ii) / [1326. Minimum Number of Taps to Open to Water a Garden -- Hard](https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/)
3. [300. Longest Increasing Subsequence -- Medium](https://leetcode.com/problems/longest-increasing-subsequence/)
4. [316. Remove Duplicate Letters -- Medium](https://leetcode.com/problems/remove-duplicate-letters/)
5. [1775. Equal Sum Arrays With Minimum Number of Operations -- Medium](https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/)

### result = min/max(selecedGroup.B) * sum(selectedGroup.A), try to get the min/max of result

2. [1383. Maximum Performance of a Team -- Hard](https://leetcode.com/problems/maximum-performance-of-a-team/)

   `performance = sum_of_speed * min_efficiency`, in order to get the max performance, we need to make `sum_of_speed`  and `min_efficiency` as large as it can be. Let's say we have  `engineers [speed, efficiency] = [[2, 5], [10, 4], [3, 3], [1, 9], [5, 7], [8, 2]]`, **only smallest efficiency is used for calculating performance**, so we try to greedily pick up the engineers with higher efficiency to make the smallest efficiency among picked engineers is relative high. We sort `engineers`, it becomes `[[1, 9], [5, 7], [2, 5], [10, 4], [3, 3], [8, 2]]`.

   lets say we need to pick up at most `k = 3` engineers. 

   + we pick up the 0th engineer `[1, 9]`,  performance is `1 * 9 = 9`, 

   + then pick up the 1st engineer, `[5, 7]`, the `min_efficiency = 7`,  the performance is `(1 + 5) * 7 = 42`;
   + then 2nd engineer, `[2, 5]`, now `min_efficiency = 5`, and performance is `(1 + 5 + 2) * 5 = 40`

   In order to use `min_efficiency = 5`, we can only choose engineers has the efficiency that higher than 5. **Then we can try different efficiency as possible `min_efficiency` , but try to keep the `sum_of_speed` as large as it can be for each possible `min_efficiency`. And calculate the performance and find the largest one**

   What if the `k` engineers are chose already, how to we determine if the largest `sum_of_speed` of the next engineer's efficiency, say the 3rd engineer, `[10, 4]`? Then use `min_heap` to track the speed of engineers, and pop out the engineer with the lowest speed, to keep `sum_of_speed` large.

   ```java
   class Engineer{
       int e;
       int s;
       Engineer(){};
       Engineer(int e, int s){this.e = e; this.s = s;}
       }
   public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
       // use PriorityQueue to remove the min speed engineer
       // try to get largest sum of speed of each engineer, 
       List<Engineer> engineers = new ArrayList<>();
       for(int i = 0; i < speed.length; i++){
         engineers.add(new Engineer(efficiency[i], speed[i]));
       }
       Collections.sort(engineers, (a, b) -> b.e - a.e); // descending
     	// speed in ascending order
       PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
       long ans = Integer.MIN_VALUE, curSpeedSum = 0;
       for(Engineer engineer : engineers){
         // keep size of the queue as k
         if(queue.size() == k) curSpeedSum -= queue.poll(); // remove slowest engineer
         queue.offer(engineer.s);
         curSpeedSum += engineer.s;
         // new engineer's efficiency will be used, since engineers is in descending order
         ans = Math.max(ans, curSpeedSum * engineer.e);
       }
     return (int) (ans % (1000000007));
   }
   ```

   

3. [857. Minimum Cost to Hire K Workers -- Hard](https://leetcode.com/problems/minimum-cost-to-hire-k-workers/)

let's define `ratio = wage / quality`, which indicates how much money does each unit of quality deserve.

Combine wokers with lower ratio with workers with higher ratio in a group will increase the pay of workers with lower ratio. We need to avoid that in order to get min cost of the group. `cost = highest_ratio * totalQuality`, the highest ratio in the group will be used for calculation, we need to try best to pick workers with lower ratio while keep total quality low, it is similar with  [1383. Maximum Performance of a Team -- Hard](#2), we try to use each ratio as possible `highest_ratio`, and find the smallest `totalQuality` for each candidate.

```java
class Worker{
        int q;
        int w;
        double ratio;
        Worker(){};
        Worker(int q, int w){this.q = q; this.w = w; ratio = (double) w / q;}
    }
public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // ratio = wage / quality
        // totalMinCost = highest_ratio * totalQuality
        // we only use the highest ratio
        // in order to make totalMinCost min, we need to make totalQuality as low as we can
        // when hired more workersthan k, we need to remove a worker, which one should we 
        // remove? the worker with largest quality, so we can totalQuality low. here we use maxheap
        List<Worker> workers = new ArrayList<>();
        for(int i = 0; i < quality.length; i++){
            workers.add(new Worker(quality[i], wage[i]));
        }
        Collections.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);// quality max heap
        double ans = Double.MAX_VALUE, totalQuality = 0;
        for(Worker worker : workers){
            totalQuality += worker.q;
            queue.offer(worker.q);
            if(queue.size() > k) totalQuality -= queue.poll();
            // exactly k workers
            if(queue.size() == k){
                // use worker.ratio,since sort in asc
                ans = Math.min(ans, totalQuality * worker.ratio);
            }
        }
        return ans;
    }
```

## Do it until we can not

[871. Minimum Number of Refueling Stops -- Hard](https://leetcode.com/problems/minimum-number-of-refueling-stops/)



## TO BE CATEGORIZED

[1147. Longest Chunked Palindrome Decomposition -- Hard](https://leetcode.com/problems/longest-chunked-palindrome-decomposition/)



## Pick the option so that later work can be easier

1. [942. DI String Match -- Easy](https://leetcode.com/problems/di-string-match/)
1. [1029. Two City Scheduling -- Medium](https://leetcode.com/problems/two-city-scheduling/)
1. [1846. Maximum Element After Decreasing and Rearranging -- Medium](https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/)
1. [484. Find Permutation -- Medium](https://leetcode.com/problems/find-permutation/)
1. [630. Course Schedule III -- Hard](https://leetcode.com/problems/course-schedule-iii/) 
1. [406. Queue Reconstruction by Height -- Medium](https://leetcode.com/problems/queue-reconstruction-by-height/)
1. [1564. Put Boxes Into the Warehouse I -- Medium](https://leetcode.com/problems/put-boxes-into-the-warehouse-i/)
1. [1580. Put Boxes Into the Warehouse II -- Medium](https://leetcode.com/problems/put-boxes-into-the-warehouse-ii)

### String Arrangment with strides

1. [767.Reorganize-String](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/767.Reorganize-String) (M+)
2. [1054.Distant-Barcodes](https://github.com/wisdompeak/LeetCode/tree/master/Greedy/1054.Distant-Barcodes) (M+)
3. [358.Rearrange-String-k-Distance-Apart](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/358.Rearrange-String-k-Distance-Apart) (H-)
4. [621.Task-Scheduler](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/621.Task-Scheduler) (H-)
5. [984.String-Without-AAA-or-BBB -- Medium](https://leetcode.com/problems/string-without-aaa-or-bbb/) 
6. [1405.Longest-Happy-String -- Medium](https://leetcode.com/problems/longest-happy-string/) 
7. [1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work](https://github.com/wisdompeak/LeetCode/tree/master/Priority_Queue/1953.Maximum-Number-of-Weeks-for-Which-You-Can-Work) (M+)

## Optimal for each small step

1. [1792. Maximum Average Pass Ratio -- Medium](https://leetcode.com/problems/maximum-average-pass-ratio/)
1. [995. Minimum Number of K Consecutive Bit Flips -- Hard](https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/)

##  Greedy and Binary Search

### LIS

**<u>tricky</u>**: sort second dimension in decreasing order to avoid the case that the first dimensions are same

1. [300. Longest Increasing Subsequence -- Medium](https://leetcode.com/problems/longest-increasing-subsequence)
3. 1713
4. [1964. Find the Longest Valid Obstacle Course at Each Position -- Hard](https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/)
5. [2111. Minimum Operations to Make the Array K-Increasing -- Hard](https://leetcode.com/problems/minimum-operations-to-make-the-array-k-increasing)
5. [1996. The Number of Weak Characters in the Game -- Medium](https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/)
6. [354. Russian Doll Envelopes -- Hard](https://leetcode.com/problems/russian-doll-envelopes)
7. [1691. Maximum Height by Stacking Cuboids -- Hard](https://leetcode.com/problems/maximum-height-by-stacking-cuboids/)
8. [646. Maximum Length of Pair Chain -- Medium](https://leetcode.com/problems/maximum-length-of-pair-chain/)
8. [435. Non-overlapping Intervals -- Medium](https://leetcode.com/problems/non-overlapping-intervals)



### Other

1. [2071. Maximum Number of Tasks You Can Assign -- Hard](https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/)

## NP - Complete

min action to achieve, key idea is each action at least achieve something to compress the state

1. [465. Optimal Account Balancing --  Hard](https://leetcode.com/problems/optimal-account-balancing/)
1. [765. Couples Holding Hands -- Hard](https://leetcode.com/problems/couples-holding-hands/)





## Other

1. [2311. Longest Binary Subsequence Less Than or Equal to K --  Medium](https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/)
