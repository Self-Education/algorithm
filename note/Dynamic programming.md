## Dynamic programming

1. [673. Number of Longest Increasing Subsequence](https://leetcode.com/problems/number-of-longest-increasing-subsequence/)

2. [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

   Note that `k` could be negative, which needs offset for **memoize**. 

   This can also be solved by using **Prefix Sum** along with **HashMap**

   ```java
   class Solution {
       public int subarraySum(int[] nums, int k) {
           int ans = 0;
           for(int i = 0; i < nums.length; i++){
               ans += dp(nums, k, i);
           }
           return ans;
       }
       // number of CS that end at index
       public int dp(int[] nums, int k, int index){
           if(index == 0) return nums[index] == k ? 1 : 0;
           int res = 0;
           if(nums[index]==k) res +=1;
           return res + dp(nums, k - nums[index], index - 1);
       }
   }
   ```

   

3. [72. Edit Distance -- Hard](https://leetcode.com/problems/edit-distance/)

4. [10. Regular Expression Matching -- Hard](https://leetcode.com/problems/regular-expression-matching/) use DP for string match

