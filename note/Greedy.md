## Greedy

1. [316. Remove Duplicate Letters -- Medium](https://leetcode.com/problems/remove-duplicate-letters/)



### result = min/max(selecedGroup.B) * sum(selectedGroup.A), try to get the min/max of result

2. [1383. Maximum Performance of a Team -- Hard](https://leetcode.com/problems/maximum-performance-of-a-team/)

   `performance = sum_of_speed * min_efficiency`, in order to get the max peformance, we need to make `sum_of_speed`  and `min_efficiency` as large as it can be. Let's say we have  `engineers [speed, efficiency] = [[2, 5], [10, 4], [3, 3], [1, 9], [5, 7], [8, 2]]`, **only smallest efficiencey is used for calcuating performance**, so we try to greedily pick up the engineers with higher efficiency to make the smallest efficiency among picked engineers is relative high. We sort `engineers`, it becomes `[[1, 9], [5, 7], [2, 5], [10, 4], [3, 3], [8, 2]]`.

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

