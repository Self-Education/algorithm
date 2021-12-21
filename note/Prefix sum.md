## Prefix sum

1.  [325. Maximum Size Subarray Sum Equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
    + HashMap store the oldest index of occurance of curSum

2. [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

   ```java
   class Solution {
       public int subarraySum(int[] nums, int k) {
           HashMap<Integer, Integer> map = new HashMap<>();// freq of sum
           int curSum = 0;
           int ans  = 0;
           for(int i = 0; i < nums.length; i++){
               curSum += nums[i];
               if(curSum == k) ans++;
               if(map.containsKey(curSum - k)){
                   ans += map.get(curSum - k);
               }
               map.put(curSum, map.getOrDefault(curSum, 0) + 1);
               // above line must be here, in case curSum - k = curSum; which means k = 0;
           }
           return ans;
       }
   }
   ```

   

3. [1477. Find Two Non-overlapping Sub-arrays Each With Target Sum -- Medium](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)
