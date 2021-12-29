# Two Pointers

## Starts at different position

### Two ends

#### LinkedList related

##### Reader and Writer

1. [1721. Swapping Nodes in a Linked List --  Medium](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/) recursion bottom up as end pointer + **template of node swap**
2. [143. Reorder List -- Medium](https://leetcode.com/problems/reorder-list/)

##### Fast and slow runner

1. [141. Linked List Cycle -- Easy](https://leetcode.com/problems/linked-list-cycle/)
2. [142. Linked List Cycle II -- Medium](https://leetcode.com/problems/linked-list-cycle-ii/) **Hare and Tortoise**
3. [19. Remove Nth Node From End of List -- Medium](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) find from the end
4. [61. Rotate List -- Medium](https://leetcode.com/problems/rotate-list/)

#### Given target, find equal/smaller/larger

```
Find larger

2, 4, 5, 8, 9, 13, 16
i								j		k
to find A[i] + A[j]  > A[k], lets fix j, if A[i] + A[j] > A[k], since all A[i + 1 :] is larger than A[i], so all number from i to j - 1 will make A[i] + A[j] > A[k], 
then count += j - i, all valid numbers paired with A[j] are found, then move j to the left
simimarly, if A[i] + A[j] < A[k], then we need to move i to right to increase sum

How about find smaller
find A[i] + A[j] < A[k], if A[i] + A[j] > A[k], A[p] + A[j] > A[k], where i <= p <= j - 1,
so j is done, we move j to the left, in this case we are fixing i.
```

1. [611. Valid Triangle Number -- Medium](https://leetcode.com/problems/valid-triangle-number)

2. [Pairs of Songs With Total Durations Divisible by 60 -- Medium](https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/)  $(a + b) \% 60 = (a \% 60 + b \% 60) \% 60$

3. [Continuous Subarray Sum -- Medium](https://leetcode.com/problems/continuous-subarray-sum/), divisible by K; 

4. [Subarray Sums Divisible by K -- Medium](https://leetcode.com/problems/subarray-sums-divisible-by-k/) $s1 = nk + r1; s2 = mk + r2; => s1 - s2 = (n - m) k + (r1 -r2)$ , when $ r1 - r2 = 0$ or  $ r1 = r2 = 0$ 

   String in between is divisible by k 

5. [Two Sum](https://leetcode.com/problems/two-sum/) `HashTable` or **sort + two pointers**

5. [633. Sum of Square Numbers -- Medium](https://leetcode.com/problems/sum-of-square-numbers/)

6. [Two Sum less than K](https://leetcode.com/problems/two-sum-less-than-k/) two pointers

7. [3Sum](https://leetcode.com/problems/3sum/) fix num1, use two sum for rest of two numbers **(Caution, duplicates!)**

8. [16. 3Sum Closest](https://leetcode.com/problems/3sum-closest/), same with 3Sum, but need to track shortest distance

9. [259. 3Sum Smaller](https://leetcode.com/problems/3sum-smaller/) `if(nums[l] + nums[r] < target) count+= r - l;`

10. [923. 3Sum With Multiplicity](https://leetcode.com/problems/3sum-with-multiplicity/), **duplicates**

11. [18. KSum](https://leetcode.com/problems/4sum/)

12. [1498. Number of Subsequences That Satisfy the Given Sum Condition -- Medium](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)

14. [1755. Closest Subsequence Sum -- Hard](https://leetcode.com/problems/closest-subsequence-sum/)

    

#### element between two pointers is valuable

1. [881. Boats to Save People -- Medium](https://leetcode.com/problems/boats-to-save-people/)
2. [259. 3Sum Smaller -- Medium](https://leetcode.com/problems/3sum-smaller/) `if(nums[l] + nums[r] < target) count+= r - l;`

#### Reverse an <u>array of string</u> or string

To reverse **each element in an array** instead of reversing the array. Eg. `str = "word1, word2 ... wordn"`, we can reverse `str` first, then reverse each word.

1. [344. Reverse String -- Easy](https://leetcode.com/problems/reverse-string/)
2. [186. Reverse Words in a String II -- Medium](https://leetcode.com/problems/reverse-words-in-a-string-ii/)
3. [557. Reverse Words in a String III -- Easy](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
4. [189. Rotate Array -- Medium](https://leetcode.com/problems/rotate-array/submissions/)

#### Wrap up/ rotate String/Array

1. [969. Pancake Sorting -- Medium](https://leetcode.com/problems/pancake-sorting/)

#### Right position

1. [922. Sort Array By Parity II -- Easy](https://leetcode.com/problems/sort-array-by-parity-ii/)



### Find unitl good candidates



1. [345. Reverse Vowels of a String --  Easy](https://leetcode.com/problems/reverse-vowels-of-a-string/)
2. [922. Sort Array By Parity II -- Easy](https://leetcode.com/problems/sort-array-by-parity-ii)

#### Mountain problem

1. [941. Valid Mountain Array -- Easy](https://leetcode.com/problems/valid-mountain-array/)
2. [845. Longest Mountain in Array -- Medium](https://leetcode.com/problems/longest-mountain-in-array/)
3. [977. Squares of a Sorted Array -- Easy](https://leetcode.com/problems/squares-of-a-sorted-array/)](https://leetcode.com/problems/longest-mountain-in-array/)
3. [777. Swap Adjacent in LR String --  Medium](https://leetcode.com/problems/swap-adjacent-in-lr-string/)





### Find and Expand

1. [658. Find K Closest Elements -- Medium](https://leetcode.com/problems/find-k-closest-elements/)
1. [1793. Maximum Score of a Good Subarray -- Hard](https://leetcode.com/problems/maximum-score-of-a-good-subarray/)
1. [1755. Closest Subsequence Sum --  Medium](https://leetcode.com/problems/closest-subsequence-sum/)
1. [927. Three Equal Parts -- Hard](https://leetcode.com/problems/three-equal-parts/)





### As reader and writer, writer only moves after writing

+ #### In place remove Element in an Array/LinkedList

```java  
public int removeDuplicates(int[] nums, int k) { // duplicates are allowed to occur occur k times
         int i = 1, j = 1, count = 1;
            while(j < nums.length){
            if(nums[j] == nums[j - 1]){
                count ++;
                
            }else{
                count = 1;
            }
            
            if(count <= k) nums[i++] = nums[j]; // as long as duplicates dont occur more than k times, write to i.
            j++;
        }
        return i;
    }
```

1. [80. Remove Duplicates from Sorted Array II -- Medium](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
2. [82. Remove Duplicates from Sorted List II -- Medium](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)
3. [83. Remove Duplicates from Sorted List --  Medium](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

#### Squeeze / interval block

3. [1861. Rotating the Box -- Medium](https://leetcode.com/problems/rotating-the-box/)



#### Swap ListNode

[1721. Swapping Nodes in a Linked List -- Medium](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)



#### adjcent swap

[1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number -- Medium](https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/)



### <u>Different speed</u>

+ 2. 

### Start at different time

​	1. [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

### Collect Water Series (Bucket water)

1. [11. Container With Most Water -- Hard](https://leetcode.com/problems/container-with-most-water)



## Other good problems

1. [160. Intersection of Two Linked Lists --Easy](https://leetcode.com/problems/intersection-of-two-linked-lists/)  

2. [234. Palindrome Linked List -- Easy](https://leetcode.com/problems/palindrome-linked-list/) use **bottom up** to achieve the second pointer starting from the end

### Next Greater/Smaller

1. [31. Next Permutation -- Medium](https://leetcode.com/problems/next-permutation)
2. [556. Next Greater Element III -- Medium](https://leetcode.com/problems/next-greater-element-iii)
3. [564. Find the Closest Palindrome -- Hard](https://leetcode.com/problems/find-the-closest-palindrome/)
4. [1842. Next Palindrome Using Same Digits](https://leetcode.com/problems/next-palindrome-using-same-digits/)

### Two arrays

1. [Merge Sorted Array -- Easy](https://leetcode.com/problems/merge-sorted-array/)  start from the end to avoid overwritten
2. [986. Interval List Intersections -- Medium](https://leetcode.com/problems/interval-list-intersections/)
3. [1229. Meeting Scheduler -- Medium](https://leetcode.com/problems/meeting-scheduler/)
3. [161. One Edit Distance -- Medium](https://leetcode.com/problems/one-edit-distance/)



### Shortest Word Distance

1. [243. Shortest Word Distance -- Easy](https://leetcode.com/problems/shortest-word-distance)
2. [244. Shortest Word Distance II -- Medium](https://leetcode.com/problems/shortest-word-distance-ii)
2. [Shortest Word Distance III -- Medium](https://leetcode.com/problems/shortest-word-distance-iii/)
3. [248. Strobogrammatic Number III](https://leetcode.com/problems/strobogrammatic-number-iii)

### to be categorized

[1574. Shortest Subarray to be Removed to Make Array Sorted](https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/)

[1163. Last Substring in Lexicographical Order - Hard](https://leetcode.com/problems/last-substring-in-lexicographical-order/)

# Sliding Window

### Shrink window size to make window valid

Every time ask for the min length of ....

1. [Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/)

2. [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)

3. [209. Minimum Size Subarray Sum -- Medium](https://leetcode.com/problems/minimum-size-subarray-sum/)

4. [862. Shortest Subarray with Sum at Least K -- Hard](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) similar with 209, but negative value, mono queue

5. [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) keep windows only contains non-duplicates or shrink( here we can use `hashmap` to store most recent index of each char)

6. [243. Shortest Word Distance](https://leetcode.com/problems/shortest-word-distance/)

7. [76. Minimum Window Substring -- Hard](https://leetcode.com/problems/minimum-window-substring)

8. [532. K-diff Pairs in an Array -- Medium](https://leetcode.com/problems/k-diff-pairs-in-an-array/)

9. [567. Permutation in String -- Medium](https://leetcode.com/problems/permutation-in-string/) We can keep the window at the fixed length

10. [438. Find All Anagrams in a String -- Medium](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

10. [1838. Frequency of the Most Frequent Element -- Medium](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)

    

###  window keep the second freq char no more than k times

1. [424. Longest Repeating Character Replacement -- Medium](https://leetcode.com/problems/longest-repeating-character-replacement/)
2. [1156. Swap For Longest Repeated Character Substring -- Medium](https://leetcode.com/problems/swap-for-longest-repeated-character-substring/)



### window keep same size

1. [567. Permutation in String -- Medium](https://leetcode.com/problems/permutation-in-string/)

### partition array into different windows

[838. Push Dominoes -- Medium](https://leetcode.com/problems/push-dominoes)

[1679. Max Number of K-Sum Pairs -- Hard](https://leetcode.com/problems/max-number-of-k-sum-pairs/)

[239. Sliding Window Maximum -- Hard](https://leetcode.com/problems/sliding-window-maximum)

[1574. Shortest Subarray to be Removed to Make Array Sorted --  Medium](https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/)
