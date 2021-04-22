## Palindrome

1. [Valid Palindrome II -- Easy](https://leetcode.com/problems/valid-palindrome-ii/), if can make the string palindromic by at most delete one letter

2. [Valid Palindrom III -- Hard](https://leetcode.com/problems/valid-palindrome-iii/submissions/),  if can make the string palindromic by at most delete K letter

3. [Palindromic Substring -- Medium](https://leetcode.com/problems/palindromic-substrings/) how many palindromic substring
4. [Longest Palindromic Substring -- Medium](https://leetcode.com/problems/longest-palindromic-substring/)

5. [Longest Palindromic Sequence -- Medium](https://leetcode.com/problems/longest-palindromic-subsequence/)

6. [Longest Palindromic Sequence II -- Medium](https://leetcode.com/problems/longest-palindromic-subsequence-ii/) even length, two consecutive characters not equal.



## Trap Rain

1. [Trapping Rain Water -- Hard](https://leetcode.com/problems/trapping-rain-water/)



## Integer and Roman

1. [Roman to Integer -- Easy](https://leetcode.com/problems/roman-to-integer/) left Roman is always larger than right
2. [Integer to Roman -- Medium](https://leetcode.com/problems/integer-to-roman/) greedy, use possible largest Roman letter to run out  each digit



## Over lap

### if there are two dimensions, sort based on one dimension, to reduce possible cases

1. [Merge Intervals -- Medium](https://leetcode.com/problems/merge-intervals/) Sort based on one dimension, to reduce possible cases
2. [SkyLine]

## Permutations

1. [Next Permutation -- Medium](https://leetcode.com/problems/next-permutation/) swap `nums[i]` with smallest larger number in `nums[i + 1, :]`



## Two Sum

1. [Pairs of Songs With Total Durations Divisible by 60 -- Medium](https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/)  $(a + b) \% 60 = (a \% 60 + b \% 60) \% 60$

2. [Continuous Subarray Sum -- Medium](https://leetcode.com/problems/continuous-subarray-sum/), divisible by K; 

3. [Subarray Sums Divisible by K -- Medium](https://leetcode.com/problems/subarray-sums-divisible-by-k/) $s1 = nk + r1; s2 = mk + r2; => s1 - s2 = (n - m) k + (r1 -r2)$ , when $ r1 - r2 = 0$ or  $ r1 = r2 = 0$ 

   String in between is divisible by k 