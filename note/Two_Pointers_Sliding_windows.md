# Two Pointers

To reverse String ` str = "word1, word2 ... wordn"`, we can reverse `str` first, then reverse each word.

1. [344. Reverse String -- Easy](https://leetcode.com/problems/reverse-string/)
2. [186. Reverse Words in a String II -- Medium](https://leetcode.com/problems/reverse-words-in-a-string-ii/)
3. [557. Reverse Words in a String III -- Easy](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
4. [189. Rotate Array -- Medium](https://leetcode.com/problems/rotate-array/submissions/)

Faster runner and slower runner, see slower runner as writer, and faster runner as reader

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



1. [977. Squares of a Sorted Array -- Easy](https://leetcode.com/problems/squares-of-a-sorted-array/)

### two arrays

1. [Merge Sorted Array -- Easy](https://leetcode.com/problems/merge-sorted-array/)  start from the end to avoid overwritten

### Mountain problem

1. [941. Valid Mountain Array -- Easy](https://leetcode.com/problems/valid-mountain-array/)
2. [845. Longest Mountain in Array -- Medium](https://leetcode.com/problems/longest-mountain-in-array/)

# Sliding Window

### make the windows always contains K zeros

1. [Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/)
2. [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)
3. [209. Minimum Size Subarray Sum -- Medium](https://leetcode.com/problems/minimum-size-subarray-sum/)
4. 

