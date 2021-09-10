1. [23. Merge k Sorted Lists -- Hard](https://leetcode.com/problems/merge-k-sorted-lists/)
2. 
3. [628. Maximum Product of Three Numbers -- Easy](https://leetcode.com/problems/maximum-product-of-three-numbers/)

## "Beautiful" series

1. [669. Beautiful Arrangement II --Medium](https://leetcode.com/problems/beautiful-arrangement-ii/solution/)

2. [932. Beautiful Array -- Medium](https://leetcode.com/problems/beautiful-array/)

   + **rule1:** odd + even != even

   + **rule2:** and above inequality is linear which means we can multiply or +/- a number at both sides, without breaking the inequality

   + for n = 5, [1, 2, 3, 4, 5], based on the rule1, we can place all odd at left side (s1) 
     and all even numbers at the right side (s2), [1, 3, 5] + [2, 4], for the universe set, 
     it meets the requirements, but how do we make s1 and s2 themselves beautiful?
     based on rule2, we can 2 * beautiful array - 1, to get a odd part
     and 2 * beautiful array to get a even part, in this way we achieve both rules.

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
