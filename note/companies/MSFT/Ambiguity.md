## Ambiguity: 

### 1. String / Array

+ **<u>Empty</u>** String
+ length **<u>1</u>**
+ Odd/Even length
+ all same chars or numbers, **<u>Duplicates</u>**?
+ All **<u>digits</u>** ? All **<u>lower</u>** case?

### 2. Node /LinkedList

+ **<u>Null</u>** 
+ BST or regular BT?
+ all Value **<u>positive</u>**??



## Ideas

### 1. String/Array

+ sort
+ count occurance
+ binary search (value and length)
+ two pointers / Sliding windows
+ DP
+ left, right look

### 2. Backtrack

+ Combination (sequence no matter) no duplicates: `index + 1`
+ Combination(sequence no matter) duplicates `index + 1` and  `nums[i] == nums[i - 1]`
+ Permutation, no duplicates: `visited` and `0`
+ permutation, duplicates: `visited` and `!visited[i - 1]`
+ Unbounded( use multiple times) : `visited` and `index`, or use first ith element