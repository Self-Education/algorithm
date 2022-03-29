## Questions

1. Length: array, string
2. include lower case, upper case, digit or letter only, or space?
3. contain duplicates



1. Watch out `l == r` when traverse from two sides
2. Integer can not have leading 0

## Tips:



### Array/String

+ sort
+ binary search
+ divide and conquer
+ two pointer / sliding window
+ count freq
+ hash
+ DP

### number in increasing order

+ LIS

### Difference

+ sort + two pointers, from the same end, note that`|A[j] - A[i]| > k`, we do not need to reset the `j`, and for `|A[j] - A[i]| < k`, if `A[j] - A[i] < k` that means for each number `a` in `A[i, j - 1]`,  `A[j] - a < k` , then we move `i`
+ when ask for number of pairs, use hash map

### Min/Max length of String/Array 

+ window and shrink

1. [209. Minimum Size Subarray Sum -- Medium](https://leetcode.com/problems/minimum-size-subarray-sum/)
1. [1838. Frequency of the Most Frequent Element -- Medium](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)

+ **subarray sum + min len** -> hashmap to record most recent occurrance 

1. [1477. Find Two Non-overlapping Sub-arrays Each With Target Sum -- Medium](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)

### Sum

#### General

+ Two sum idea
    + map/set to record occurance along the way
    + Sort
+ prefixSum to get the subArray sum
+ **2 array sum** convert it to matrix
+ **Multiple arrays** 双向奔赴

#### Subarray sum (consecutive)

+ Prefix sum + HashMap
    1. [1477. Find Two Non-overlapping Sub-arrays Each With Target Sum -- Medium](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)
+ prefix sum + binary search (since prefixSum is increasing if all number is positive)
+ if prefix sum is negative, use deque
    1. [918. Maximum Sum Circular Subarray -- Medium](https://leetcode.com/problems/maximum-sum-circular-subarray/)

+ sliding window
    1. [209. Minimum Size Subarray Sum -- Medium](https://leetcode.com/problems/minimum-size-subarray-sum/)

### Subarray letter freq

+ Hash + prefix + bitmask
  + [1915. Number of Wonderful Substrings --  Medium](https://leetcode.com/problems/number-of-wonderful-substrings/)
   + [1542. Find Longest Awesome Substring -- Hard](https://leetcode.com/problems/find-longest-awesome-substring/)
   + [525. Contiguous Array -- Medium](https://leetcode.com/problems/contiguous-array/)

### K operations, to achieve max/min or maximize min or minimize max

+ Binary search

    

### K Operations, to achieve a goal

+ `dp(i, j, k)`
+ `dp(i, j)` as least number of operations to achieve the goal, then compare if `dp(i, j) <= k`

### Intervals

+ sort by interval[i]
+ **if Interval can be accessed (overlapped)** priorityQueue (eaten apple)
    + [1705. Maximum Number of Eaten Apples -- Medium](https://leetcode.com/problems/maximum-number-of-eaten-apples/)


### Shortest/Longest path

+ BFS / DFS


### When asks for number of ...

+ DP

### Find kth largest/smallest/frequent

+ PriorityQueue
+ Binary search
+ quick sort/select

### Matrix Rectangle/Square 

+ histogram
+ surrounding cells
+ kadane algo
+ dp

### BST

+ in-order traverse (ascending order)



### first greater or smaller

+ Mono stack

### 1 - n range find missing

+ mark index

### Distance

+ binary search `[target - dist, target + dist]`: 
    1. [1385. Find the Distance Value Between Two Arrays -- Easy](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/)
+ binary search
+ Median:
    + [1478. Allocate Mailboxes -- Hard](https://leetcode.com/problems/allocate-mailboxes/)




### LinkedList find position

+ two pointers with different speed or start at different time

### search / find range

+ binary search

### closest target

+ heap
+ binary search (find and expand)

### cycle

+ union and find
  + DFS ( with state)

### Parentheses/Cancel

+ count left + right
+ stack, left over is unbalanced



### Minimize `abs(max - min)`

+ PriorityQueue 

[632. Smallest Range Covering Elements from K Lists -- Hard](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/)

+ expand from max and min, `sumMax - sumMin`

[2104. Sum of Subarray Ranges](https://leetcode.com/problems/sum-of-subarray-ranges/) 



### Backward

if cannot solve frontward, then try backward

[991. Broken Calculator](https://leetcode.com/problems/broken-calculator/)



