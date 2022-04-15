1. [23. Merge k Sorted Lists -- Hard](https://leetcode.com/problems/merge-k-sorted-lists/)
2. [423. Reconstruct Original Digits from English -- Medium](https://leetcode.com/problems/reconstruct-original-digits-from-english/)
3. [628. Maximum Product of Three Numbers -- Easy](https://leetcode.com/problems/maximum-product-of-three-numbers/)

## "Beautiful" series

1. [669. Beautiful Arrangement II --Medium](https://leetcode.com/problems/beautiful-arrangement-ii/solution/)

1. [526. Beautiful Arrangement -- Medium](https://leetcode.com/problems/beautiful-arrangement/)

2. [932. Beautiful Array -- Medium](https://leetcode.com/problems/beautiful-array/)

   + **rule1:** odd + even != even

   + **rule2:** and above inequality is linear which means we can multiply or +/- a number at both sides, without breaking the inequality

   + for n = 5, [1, 2, 3, 4, 5], based on the rule1, we can place all odd at left side (s1) 
     and all even numbers at the right side (s2), [1, 3, 5] + [2, 4],
     
     if s1 and s2 are beautiful, then `s1[i] + s2[j]`  is odd, half of the sum is fraction which cannot be present in the array, in conclusion: if two arrays are beautiful , then combination of two arrays are beautiful as well
     
  ```
     ans[1] = [1]
     ans[2] = [1, 2]
     ans[3] = 2 * ans[2] - 1 and 2 * ans[1] = [1, 3] + [2] = [1, 3, 2]
     ans[4] = 2 * ans[2] - 1 and 2 * ans[2] = [1, 3] + [2, 4] = [1, 3, 2, 4]
     ans[5] = 2 * ans[3] - 1 and 2 * ans[2] = [1, 5, 3] + [2, 4] = [1, 5, 3, 2, 4]
     ans[6] = 2 * ans[3] - 1 and 2 * ans[3]
     ans[n] = 2 * ans[(n + 1) / 2] and 2 * ans[n / 2]
  ```

  



## Pascal Triangle as combination

[Wiki](https://www.mathsisfun.com/pascals-triangle.html#:~:text=Entry%20in%20The-,Triangle,-In%20fact%20there)

1. [ Number of Ways to Reorder Array to Get Same BST -- Hard](https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst)



[899. Orderly Queue](https://leetcode.com/problems/orderly-queue)



## Interactive problems

1. [843. Guess the Word - Hard](https://leetcode.com/problems/guess-the-word/)





## Simulation

1. [950. Reveal Cards In Increasing Order -- Medium](https://leetcode.com/problems/reveal-cards-in-increasing-order/)

## Other

[782. Transform to Chessboard](https://leetcode.com/problems/transform-to-chessboard) chess board only has two types of rows, swaps rows/cols, does not change equality of same type of row/cols

[1332. Remove Palindromic Subsequences -- Easy](https://leetcode.com/problems/remove-palindromic-subsequences/)

[1217. Minimum Cost to Move Chips to The Same Position -- Easy](https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/)

[942. DI String Match - Easy](https://leetcode.com/problems/di-string-match/)

[790. Domino and Tromino Tiling -- Medium](https://leetcode.com/problems/domino-and-tromino-tiling/)

[754. Reach a Number -- Medium](https://leetcode.com/problems/reach-a-number/)


