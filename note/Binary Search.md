## Binary Search

#### Questions:

+ **Why is there an infinite loop if we use `left = mid`?**
  + when use `left = mid` , for sure there will be an infinite loop, but **why**? The infinite loop occurs when `left` and `right` move to two adjacent elements,` right = left + 1`then  `mid = (left + right)/2` =>  `mid = (left * 2 + 1)/2`, due to java round the `int` to left side, them `mid = left`. Therefore, when we use `left = mid`, mid keeps the same forever! However, if we use `right = mid`, then `mid = (right * 2 - 1)/2` => `mid = right - 1`, `right` decrements by one for each loop. **we need to use `mid = (left + right)/2 + 1` when we use `left = mid` to increment `left`**.
  + Please note that we have to use `left < right` for `while` condition if we used `mid = (left + right)/2 +1`, other wise, **infinite loop**. Because if `left` and `right` stop at the same index,  `mid = (left + left)/2 + 1 = left + 1` , if `nums[mid] > target` then `right = mid - 1 = left`. e.g. search 4 in `[0, 3]`, `mid = (0 + 1)/2 + 1 = 1` and `nums[1] < 4 ` => `right = 1 - 1 = 0` now `left = right = 0`, then `mid = 1 ` **again** 
  + **summary** 
    + `mid = left + (right - 1)/2` ,` mid` is always at the left side if `left` and `right` stay adjacent
    + `left = mid` + `left < right` + `mid = left + (right - 1)/2 + 1`
    + `right = mid` + `left < right` + `mid = left + (right - 1)/2`

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

