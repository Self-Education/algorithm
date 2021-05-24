## Palindrome

1. [Valid Palindrome II -- Easy](https://leetcode.com/problems/valid-palindrome-ii/), if can make the string palindromic by at most delete one letter
2. [Valid Palindrom III -- Hard](https://leetcode.com/problems/valid-palindrome-iii/submissions/),  if can make the string palindromic by at most delete K letter
3. [Palindromic Substring -- Medium](https://leetcode.com/problems/palindromic-substrings/) how many palindromic substring
4. [Longest Palindromic Substring -- Medium](https://leetcode.com/problems/longest-palindromic-substring/)
5. [Longest Palindromic Sequence -- Medium](https://leetcode.com/problems/longest-palindromic-subsequence/)
6. [Longest Palindromic Sequence II -- Medium](https://leetcode.com/problems/longest-palindromic-subsequence-ii/) even length, two consecutive characters not equal.
7. [564. Find the Closest Palindrome --  Hard](https://leetcode.com/problems/find-the-closest-palindrome/)



## Trap Rain

1. [Trapping Rain Water -- Hard](https://leetcode.com/problems/trapping-rain-water/)



## Integer and Roman

1. [Roman to Integer -- Easy](https://leetcode.com/problems/roman-to-integer/) left Roman is always larger than right
2. [Integer to Roman -- Medium](https://leetcode.com/problems/integer-to-roman/) greedy, use possible largest Roman letter to run out  each digit



## Over lap

### if there are two dimensions, sort based on one dimension, to reduce possible cases

1. [Merge Intervals -- Medium](https://leetcode.com/problems/merge-intervals/) Sort based on one dimension, to reduce possible cases
2. [SkyLine]
3. Meeting 
4. Meeting II

## Permutations

1. [Next Permutation -- Medium](https://leetcode.com/problems/next-permutation/) swap `nums[i]` with smallest larger number in `nums[i + 1, :]`



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

## Matrix

1. [54. Spiral Matrix -- Medium](https://leetcode.com/problems/spiral-matrix/)
2. [885. Sprial Matrix III -- Medium](https://leetcode.com/problems/spiral-matrix-iii/) move pattern : 1, 1, 2, 2, 3, 3, ...
3. Rotate image

+ #### **Search Sorted Matrix**

  Idea: elements on the right side are larger and elements on the top are smaller, then <u>search either from bottom left or top right</u>, **template**:

  ```java
  public boolean searchMatrix(int[][] matrix, int target) {
          //search from either from bottom left corner or top right corner
          int height = matrix.length;
          if(height <= 0) return false;
          int width = matrix[0].length;
          int row = height - 1;
          int col = 0;
          while(row >= 0 && col < width){
              if(matrix[row][col] == target){
                  return true;
              }else if(matrix[row][col] < target){
                  col ++;
              }else{
                  row --;
              }
          }
          return false;
      }
  ```

1. [74. Search a 2D Matrix -- Medium](https://leetcode.com/problems/search-a-2d-matrix/)
2. [240. Search a 2D Matrix II -- Medium](https://leetcode.com/problems/search-a-2d-matrix-ii/)



## Soduku 

How to check repetition? use string such as " 9 in row 1", "9 in col 1", "9 in block 1";

1. [37. Sudoku Solver -- Hard](https://leetcode.com/problems/sudoku-solver/)
2. [36. Valid Sudoku -- Medium](https://leetcode.com/problems/valid-sudoku/)



## Basic Calculator

1. [772. Basic Calculator III](https://leetcode.com/problems/basic-calculator-iii/)
2. [394. Decode String](https://leetcode.com/problems/decode-string/)



## Serialize and Deserialize Binary Tree / N-ary Tree

1. [297. Serialize and Deserialize Binary Tree -- Hard](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)
2. [449. Serialize and Deserialize BST -- Medium](https://leetcode.com/problems/serialize-and-deserialize-bst/) preorder
3. [428. Serialize and Deserialize N-ary Tree -- Hard](https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/)



## Lowest Common Ancester for Tree

1. [235. Lowest Common Ancestor of a Binary Search Tree --Easy](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)
2. [236. Lowest Common Ancestor of a Binary Tree -- Medium](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
3. [1644. Lowest Common Ancestor of a Binary Tree II -- Medium](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/)



## Look Binary tree from different angle

1.[314. Binary Tree Vertical Order Traversal -- Medium](https://leetcode.com/problems/binary-tree-vertical-order-traversal/)



## Avoid adjacent char same or K distance away between same char

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

