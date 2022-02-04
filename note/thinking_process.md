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

### Difference

+ sort + two pointers, from the same end, note that`|A[j] - A[i]| > k`, we do not need to reset the `j`, and for `|A[j] - A[i]| < k`, if `A[j] - A[i] < k` that means for each number `a` in `A[i, j - 1]`,  `A[j] - a < k` , then we move `i`

### String/Array Min/Max length

+ window and shrink

1. [209. Minimum Size Subarray Sum -- Medium](https://leetcode.com/problems/minimum-size-subarray-sum/)
1. [1838. Frequency of the Most Frequent Element -- Medium](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)

+ hashmap to record most recent occurrance 

1. [1477. Find Two Non-overlapping Sub-arrays Each With Target Sum -- Medium](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)

### Subarray sum (consecutive)

+ Prefix sum + HashMap
    1. [1477. Find Two Non-overlapping Sub-arrays Each With Target Sum -- Medium](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/)
+ prefix sum + binary search (since prefixSum is increasing if all number is positive)
+ sliding window
    1. [209. Minimum Size Subarray Sum -- Medium](https://leetcode.com/problems/minimum-size-subarray-sum/)



### K operations, to achieve max/min or maximize min or minimize max

+ Binary search

    

### K Operations, to achieve a goal

+ `dp(i, j, k)`
+ `dp(i, j)` as least number of operations to achieve the goal, then compare if `dp(i, j) <= k`

### Intervals

+ sort by interval[i]

### Shortest/Longest path

+ BFS / DFS



### minimize/maximize Max/Min value

+ Binary search (guess and validate)



### Sum

+ Two sum idea
  + map/set to record occurance along the way
  + Sort

+ prefixSum to get the subArray sum


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

+ binary search [target - dist, target + dist]: 
    1. [1385. Find the Distance Value Between Two Arrays -- Easy](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/)
+ binary search



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
