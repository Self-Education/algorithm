## Palindrome

1. [Valid Palindrome II -- Easy](https://leetcode.com/problems/valid-palindrome-ii/), if can make the string palindromic by at most delete one letter
2. [Valid Palindrome III -- Hard](https://leetcode.com/problems/valid-palindrome-iii/submissions/),  if can make the string palindromic by at most delete K letter
3. [Palindromic Substring -- Medium](https://leetcode.com/problems/palindromic-substrings/) how many palindromic substring
4. [Longest Palindromic Substring -- Medium](https://leetcode.com/problems/longest-palindromic-substring/)
5. [Longest Palindromic Sequence -- Medium](https://leetcode.com/problems/longest-palindromic-subsequence/)
6. [Longest Palindromic Sequence II -- Medium](https://leetcode.com/problems/longest-palindromic-subsequence-ii/) even length, two consecutive characters not equal.
7. [564. Find the Closest Palindrome --  Hard](https://leetcode.com/problems/find-the-closest-palindrome/)
7. [1332. Remove Palindromic Subsequences -- Easy](https://leetcode.com/problems/remove-palindromic-subsequences/)

## Parenthesis

### rule:

+ valid parenthesis has two patterns : `( ( ) )` and `( ) ( )`,
+ `countLeft >= countRight`
+ Usually can be solved by **DP**

```java
if(s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1];
// or
for(int k = i; k < j; k++){
    if(dp[i][k] && dp[k + 1][j]){
        dp[i][j] = true;
        break;
    }
}
```

1. [678. Valid Parenthesis String -- Medium](https://leetcode.com/problems/valid-parenthesis-string/)
2. [1963. Minimum Number of Swaps to Make the String Balanced -- Medium](https://leetcode.com/contest/weekly-contest-253/problems/minimum-number-of-swaps-to-make-the-string-balanced/) observe first couple of examples ( n = 1, n = 2, n = 3, ...) to find out the pattern

## Longest ?? Subarray/Subsequence

1. [300. Longest Increasing Subsequence --  Medium](https://leetcode.com/problems/longest-increasing-subsequence/) DP for sure, but **<u>Greedy + Binary Search</u>** is much faster
2. [1964. Find the Longest Valid Obstacle Course at Each Position -- Hard](https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position)
3. [521. Longest Uncommon Subsequence I -- Hard](https://leetcode.com/problems/longest-uncommon-subsequence-i)
4. [522. Longest Uncommon Subsequence II -- Medium](https://leetcode.com/problems/longest-uncommon-subsequence-ii)



## Reverse

1. [189. Rotate Array -- Hard](https://leetcode.com/problems/rotate-array/) O(1) space

## Remove duplicates in sorted array template

```java
private int removeKDuplicates(int[] nums, int k){
        int i = 1, j = 1, count = 1;
        for(; j < nums.length; j++){
            if(nums[j] == nums[j - 1]){
                count++;
            }else{
                count = 1;
            }
            if(count <= k){
                nums[i++] = nums[j];
            }
        }
        return i;
    }
```

1. [26. Remove Duplicates from Sorted Array -- Easy](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
2. [80. Remove Duplicates from Sorted Array II -- Medium](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

## Trap Rain

1. [Trapping Rain Water -- Hard](https://leetcode.com/problems/trapping-rain-water/)
2. [11. Container With Most Water -- Medium](https://leetcode.com/problems/container-with-most-water/)



## looking from the left side and right side

1. [926. Flip String to Monotone Increasing -- Medium](https://leetcode.com/explore/item/3876)
2. [135. Candy -- Hard](https://leetcode.com/problems/candy)
3. [238. Product of Array Except Self -- Medium](https://leetcode.com/problems/product-of-array-except-self/)
4. [239. Sliding Window Maximum -- Hard](https://leetcode.com/problems/sliding-window-maximum)

## Shortest Path (BFS or binary BFS)

1. [127. Word Ladder -- Hard](https://leetcode.com/problems/word-ladder/)
2. [126. Word Ladder II -- Hard](https://leetcode.com/problems/word-ladder-ii/)

## Integer and Roman

1. [Roman to Integer -- Easy](https://leetcode.com/problems/roman-to-integer/) left Roman is always larger than right
2. [Integer to Roman -- Medium](https://leetcode.com/problems/integer-to-roman/) greedy, use possible largest Roman letter to run out  each digit



## Over lap / Intervals

See **Merge/Insert Intervals** section  in **Stack_Heap.md**



## Chess Queen

[51. N-Queens -- Hard](https://leetcode.com/problems/n-queens)

## Permutations in String

1. [Next Permutation -- Medium](https://leetcode.com/problems/next-permutation/) swap `nums[i]` with smallest larger number in `nums[i + 1, :]`
2. [1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number -- Medium](https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/)

## Two Sum/Three Sum/4Sum

1. [Pairs of Songs With Total Durations Divisible by 60 -- Medium](https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/)  $(a + b) \% 60 = (a \% 60 + b \% 60) \% 60$

2. [Continuous Subarray Sum -- Medium](https://leetcode.com/problems/continuous-subarray-sum/), divisible by K; 

3. [Subarray Sums Divisible by K -- Medium](https://leetcode.com/problems/subarray-sums-divisible-by-k/) $s1 = nk + r1; s2 = mk + r2; => s1 - s2 = (n - m) k + (r1 -r2)$ , when $ r1 - r2 = 0$ or  $ r1 = r2 = 0$ 

   String in between is divisible by k 

4. [Two Sum](https://leetcode.com/problems/two-sum/) `HashTable` or **sort + two pointers**

5. [Two Sum less than K](https://leetcode.com/problems/two-sum-less-than-k/) two pointers

6. [3Sum](https://leetcode.com/problems/3sum/) fix num1, use two sum for rest of two numbers **(Caution, duplicates!)**

7. [16. 3Sum Closest](https://leetcode.com/problems/3sum-closest/), same with 3Sum, but need to track shortest distance

8. [259. 3Sum Smaller](https://leetcode.com/problems/3sum-smaller/) `if(nums[l] + nums[r] < target) count+= r - l;`

9. [923. 3Sum With Multiplicity](https://leetcode.com/problems/3sum-with-multiplicity/), **duplicates**

10. [18. KSum](https://leetcode.com/problems/4sum/)

11. [1498. Number of Subsequences That Satisfy the Given Sum Condition -- Medium](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)

11. [1755. Closest Subsequence Sum -- Hard](https://leetcode.com/problems/closest-subsequence-sum/)

## Matrix

See matrix.md



## Stone Games

see **Union & Find** section in **graph.md**



## Jump Game

see **Jump Game** section in **Dynamic Programming.md**

[1871. Jump Game VII -- Medium](https://leetcode.com/problems/jump-game-vii/) tricky way to avoid processing same position

## Soduku 

How to check repetition? use string such as **" 9 in row 1", "9 in col 1", "9 in block 1"**;

1. [37. Sudoku Solver -- Hard](https://leetcode.com/problems/sudoku-solver/)
2. [36. Valid Sudoku -- Medium](https://leetcode.com/problems/valid-sudoku/)



## Calculator

1. See **Backtracking.md** -> **Calculation** for Basic Calculation series
2. [43. Multiply Strings -- Medium](https://leetcode.com/problems/multiply-strings/)





## Serialize and Deserialize Binary Tree / N-ary Tree

1. [297. Serialize and Deserialize Binary Tree -- Hard](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
2. [449. Serialize and Deserialize BST -- Medium](https://leetcode.com/problems/serialize-and-deserialize-bst/) preorder
3. [428. Serialize and Deserialize N-ary Tree -- Hard](https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/)



## Lowest Common Ancestor for Tree

1. [235. Lowest Common Ancestor of a Binary Search Tree --Easy](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
2. [236. Lowest Common Ancestor of a Binary Tree -- Medium](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
3. [1644. Lowest Common Ancestor of a Binary Tree II -- Medium](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/)
4. [1087. Brace Expansion](https://leetcode.com/problems/brace-expansion/)
5. [1096. Brace Expansion II](https://leetcode.com/problems/brace-expansion-ii/)
6. [282. Expression Add Operators -- Hard](https://leetcode.com/problems/expression-add-operators/)



## Look Binary tree from different angle

1.[314. Binary Tree Vertical Order Traversal -- Medium](https://leetcode.com/problems/binary-tree-vertical-order-traversal/)

## Tree related distance

1. [863. All Nodes Distance K in Binary Tree -- Medium](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) turn it into graph and BFS

## Avoid adjacent char same or K distance away between same char ( template)

use **Waiting List**

1. [767. Reorganize String -- Medium](https://leetcode.com/problems/reorganize-string/)

2. [358. Rearrange String k Distance Apart](https://leetcode.com/problems/rearrange-string-k-distance-apart/)

```java
 public String rearrangeString(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        char[] ca = s.toCharArray();
        for(char c : ca){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(char key : freq.keySet()){
            int[] temp = new int[]{key - 'a', freq.get(key)};
            queue.offer(temp);
        }
        // waiting queue
        Queue<int[]> waitList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            sb.append((char)(cur[0] + 'a'));
            cur[1]--;
            waitList.offer(cur);
            if(waitList.size() < k) continue;
            int[] back = waitList.poll();
            if(back[1] > 0){
                queue.offer(back);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "" ;
    }
```

## Dates and days different related

count from 1900

1. [1360. Number of Days Between Two Date -- Easy](https://leetcode.com/problems/number-of-days-between-two-dates/)
2. [1154. Day of the Year -- Easy](https://leetcode.com/problems/day-of-the-year/)



## Stack

<u>see "Stack_Heap.md"</u>

## Need to make index smaller than current index

1. [315. Count of Smaller Numbers After Self -- Hard](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)
2. [493. Reverse Pairs -- Hard](https://leetcode.com/problems/reverse-pairs/)



## Vowels

1. [1220. Count Vowels Permutation -- Hard](https://leetcode.com/problems/count-vowels-permutation/)
2. [966. Vowel Spellchecker -- Hard](https://leetcode.com/problems/vowel-spellchecker/)





## Clone questions

1. [138. Copy List with Random Pointer -- Medium](https://leetcode.com/problems/copy-list-with-random-pointer/)





## Rolling Hash / Index mark/ cyclic indexing

1. [41. First Missing Positive -- Hard](https://leetcode.com/problems/first-missing-positive)
2. [448. Find All Numbers Disappeared in an Array -- Easy](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
3. [442. Find All Duplicates in an Array -- Medium](https://leetcode.com/problems/find-all-duplicates-in-an-array/)
4. [565. Array Nesting -- Medium](https://leetcode.com/problems/array-nesting/)





## Merge Intervals

1. [56. Merge Intervals -- Medium](https://leetcode.com/problems/merge-intervals)
2. [57. Insert Interval -- Medium](https://leetcode.com/problems/insert-interval)
3. [253. Meeting Rooms II -- Medium](https://leetcode.com/problems/meeting-rooms-ii)

(in)



## Majority of numbers in an array (Moore Voting Algorithm)

1. [169. Majority Element -- Easy](https://leetcode.com/problems/majority-element/)
2. [229. Majority Element II -- Medium](https://leetcode.com/problems/majority-element-ii) need to verify if it is not guaranteed to have such numbers 





## Range caching

1. [370. Range Addition -- Medium](https://leetcode.com/problems/range-addition)
2. [598. Range Addition II -- Easy](https://leetcode.com/problems/range-addition-ii)





## Rolling Hash / Hash String into number 

1. [249. Group Shifted Strings -- Medium](https://leetcode.com/problems/group-shifted-strings)
2. [49. Group Anagrams -- Medium](https://leetcode.com/problems/group-anagrams/)
3. [1044. Longest Duplicate Substring --  Hard](https://leetcode.com/problems/longest-duplicate-substring/)
4. [1062. Longest Repeating Substring -- Medium](https://leetcode.com/problems/longest-repeating-substring)



## Do it until we can not

[871. Minimum Number of Refueling Stops -- Hard](https://leetcode.com/problems/minimum-number-of-refueling-stops/)



## String/Array Manipulation

1. [777. Swap Adjacent in LR String -- Medium](https://leetcode.com/problems/swap-adjacent-in-lr-string/)

2. [1574. Shortest Subarray to be Removed to Make Array Sorted  -- Medium](https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/)
