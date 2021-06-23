## Binary Search

#### Questions:

+ **Why is there an infinite loop if we use `left = mid`?**
  + when use `left = mid` , for sure there will be an infinite loop, but **why**? The infinite loop occurs when `left` and `right` move to two adjacent elements,` right = left + 1`then  `mid = (left + right)/2` =>  `mid = (left * 2 + 1)/2`, due to java round the `int` to left side, them `mid = left`. Therefore, when we use `left = mid`, mid keeps the same forever! However, if we use `right = mid`, then `mid = (right * 2 - 1)/2` => `mid = right - 1`, `right` decrements by one for each loop. **we need to use `mid = (left + right)/2 + 1` when we use `left = mid` to increment `left`**.
  + Please note that we have to use `left < right` for `while` condition if we used `mid = (left + right)/2 +1`, other wise, **infinite loop**. Because if `left` and `right` stop at the same index,  `mid = (left + left)/2 + 1 = left + 1` , if `nums[mid] > target` then `right = mid - 1 = left`. e.g. search 4 in `[0, 3]`, `mid = (0 + 1)/2 + 1 = 1` and `nums[1] < 4 ` => `right = 1 - 1 = 0` now `left = right = 0`, then `mid = 1 ` **again** 
  + **summary** 
    + `mid = left + (right - l)/2` ,` mid` is always at the left side if `left` and `right` stay adjacent
    + use them together: `left = mid` + `left < right` + `mid = left + (right - 1eft)/2 + 1`
    + `right = mid` + `left < right` + `mid = left + (right - 1eft)/2`

```java
int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right)/2 + 1;
            if(nums[mid] ==  target){
                return mid;
            }else if(nums[mid] < target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        
        return nums[left] ==  target ?  left : -1;
```



+ **When do we use `left < right` or `left <= right` ?**

```java
int l = 0, r = arr.length - 1, mid = -1;
        while(l <= r){// how about using l < r?
            mid = l + (r - l)/2;
            if(arr[mid] == x){
				return mid
            }else if(arr[mid] < x){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
		return -1;
```

with `l < r`, the element at the index `r` is excluded,  e.g. search 2 in `[1, 2]` will fail.

+ **How do I find the <u>range</u> of the target, if the target does not exist in the array ?**

```java
int l = 0, r = arr.length - 1, mid = -1;
        while(l <= r){
            mid = l + (r - l)/2;
            if(arr[mid] == x){
                r = mid;
                l = mid;
                break;
            }else if(arr[mid] < x){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
		// now r is the lower bound of the target, l is the upper bound
		if(r == l){// when target is found
            
        }
```

### basic examples

+ find the smallest number that is greater than the target

  ```java
  private int search(List<Integer> nums, int target){
          // try to find the smallest index that greater than target 
          if(indice == null) return -1;
          int l = 0, r = nums.size() - 1, ans = Integer.MAX_VALUE;
          while(l <= r){
              int mid = l + (r - l) / 2;
              if(nums.get(mid) < prev){
                  l = mid + 1;
              }else{
                  ans = Math.min(ans, nums.get(mid));
                  r = mid - 1;
              }
          }
          // System.out.println(ans);
          return ans == Integer.MAX_VALUE ? -1 : ans;
      }
      
  ```

  



#### [<u>410. Split Array Largest Sum</u>](https://leetcode.com/problems/split-array-largest-sum/)

*Given an array `nums` which consists of non-negative integers and an integer `m`, you can split the array into `m` non-empty **continuous** subarrays.*

*Write an algorithm to minimize the largest sum among these `m` subarrays.*



**Binary Search**, **Two Pointers**, **Window**, and **DP** should come into the mind, when see **array** and **sum**. DP and Binary Search can be used for this problem, here we use binary search.

Since the array is not sorted, we need to find something are sorted in order to use binary search. We do not know the value of minimum largest sum, but we know the range which is from $Max(arr)$ to  $\sum{arr[i]}$.

Why? if we divide the `arr` into `arr.length` subarrays, the largest sum of subarray has to be the largest element in the array and if we divide the `arr` into 1 subarray (actually itself), the sum is  $\sum{arr[i]}$.

We use `lo`  and `hi` as the lower bound and higher bound respectively. We can use binary search to pick up a `mid` between the range and to see if we can divide the `arr` into `k ` subarrays, and sum of each subarray is no larger than the `mid`.  We can see this `mid ` as split requirement, we can fit more numbers into each subarray with higher `mid`, and similarly, we can fit less numbers into each subarray with lower `mid`. 

 

There are three cases:

+ if `k > m`, that means we can divide `arr` into more subarrays (each subarray has a sum no larger than mid), we need to fit more numbers into each array in order to get less subarray, so we need to loose our requirement, then `lo= mid + 1`

+ if `k < m`, that means we can divide `arr` into less subarrays, we need to tighten our requirement, so that less numbers fits into each array and more subarrays obtained. **Please note that `k` here indicates minimum number of the subarrays** with specific largest sum. e.g. `[2, 3, 1, 1, 1, 1, 1]`, if we can divide an array into  minimum 4 subarrays with largest sum 3, it is possible that we can divide the array into 5 subarrays with sum 3. So `mid` might be the answer as well. `hi = mid`

* if `k == m`:  the current `mid` is a good candidate,  then `hi = mid`

```java
public int splitArray(int[] nums, int m) {
        long lo = 0, hi = 0, mid = -1, sum = 0, count = 1;
        for(int num : nums){
            hi += num;
            if(lo < num){
                lo = num;
            }
        }
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            sum = 0;
            count = 1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] + sum <= mid){
                    sum += nums[i];
                }else{
                    sum = nums[i];
                    count++;
                }
            }
            if(count <= m){
                hi = mid;
    
            }else {
                lo = mid + 1;
            }
        }
        return (int) lo;
    }
```









#### **[719. Find K-th Smallest Pair Distance](https://leetcode.com/problems/find-k-th-smallest-pair-distance/)**

Similar with #410, the array is not sorted, so we sort the array, so that for each `arr[i]`, `arr[j + 1] - arr[i] > arr[j] - arr[i]`. the lower bound `lo` is smallest possible distance which is 0, and upper bound `upper`  would be the difference between the first element and the last element. We pick up possible  distance `mid` so see how many pairs `count` with `sum <= mid`, three cases:

+ if `count == k`, then the mid is the kth smallest distance
+ if `count < k`, that means mid is too small, so make lower bound higher, `lo = mid + 1`
+ if `count > k`, that means mid is too large, here is the trickiest part, lets say the we want to find 3rd smallest pair distance and  **distance array** is `[0, 1, 3, 3, 4, 5, 6]`, now `mid = (0 + 6)/2 = 3`( the second 2) and `count = 4`,  if we use `hi = mid - 1 = 2`, but obviously 3rd smallest distance is 3. In other words, should use `hi = mid` because of the duplicate of the distance 

```java
1231. Divide Chocolatepublic int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0], mid = -1;
        while(left <  right){
            mid = left + (right - left)/2;
            int count = helper(nums, mid);
            if(count >= k){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    // return number of pairs whose distance is no larger than target
    public int helper(int[] nums, int target){
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                // because nums is sorted, then all numbers at the right side of
                // j has larger distance against i, so we can stop eariler
                if(nums[j] - nums[i] > target){
                    break;
                }
                count++;
            }
        }
        return count;
    }
```

#### [1011. Capacity To Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)

#### [875. Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)

#### [1231. Divide Chocolate](https://leetcode.com/problems/divide-chocolate/)

[792. Number of Matching Subsequences](https://leetcode.com/problems/number-of-matching-subsequences/)

