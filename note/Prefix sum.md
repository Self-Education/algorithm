## Prefix sum

## General

1. [2132. Stamping the Grid -- Hard](https://leetcode.com/problems/stamping-the-grid/)

## Count sum of interval

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

4. [2106. Maximum Fruits Harvested After at Most K Steps -- Hard](https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/)

3. [525. Contiguous Array -- Medium](https://leetcode.com/problems/contiguous-array/)

## Count Freq for ranges

1. [1862. Sum of Floored Pairs --  Hard](https://leetcode.com/problems/sum-of-floored-pairs/)
1. [2055. Plates Between Candles -- Medium](https://leetcode.com/problems/plates-between-candles/)

### hash + prefix

	1. [1915. Number of Wonderful Substrings --  Medium](https://leetcode.com/problems/number-of-wonderful-substrings/)
	1. [1542. Find Longest Awesome Substring -- Hard](https://leetcode.com/problems/find-longest-awesome-substring/)
	1. [525. Contiguous Array -- Medium](https://leetcode.com/problems/contiguous-array/)
	1. [930. Binary Subarrays With Sum -- Medium](https://leetcode.com/problems/binary-subarrays-with-sum/)
	1. [1524. Number of Sub-arrays With Odd Sum -- Medium](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/)

## Track as you go

1. [2054. Two Best Non-Overlapping Events -- Medium](https://leetcode.com/problems/two-best-non-overlapping-events/)

### Diagonal

[1878. Get Biggest Three Rhombus Sums in a Grid -- Medium](https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/)

