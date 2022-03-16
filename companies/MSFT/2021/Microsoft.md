# Microsoft

1. [1647. Minimum Deletions to Make Character Frequencies Unique -- Medium](https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique)
2. [Minimum Adjacent swaps to make palindrome](https://leetcode.com/discuss/interview-question/351783/)
3. [1578. Minimum Deletion Cost to Avoid Repeating Letters -- Medium](https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/) stack store only non duplicates, compare costs.
4. [Minimum characters that are to be inserted such that no three consecutive characters are same](https://www.geeksforgeeks.org/minimum-characters-that-are-to-be-inserted-such-that-no-three-consecutive-characters-are-same/)
5. [Min Moves/Change to Make String Without 3 Identical Consecutive Letters](https://code.sololearn.com/c9a24a6A11a1)
6. [1703. Minimum-Adjacent-Swaps-for-k-Consecutive-Ones -- Hard](https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/discuss/987347/JavaC%2B%2BPython-Solution)
7. [Largest K such that both K and -K exist in array](https://leetcode.com/discuss/interview-question/406031/) V- shape
8. [Max Length of a Concatenated String with Unique Characters](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/)
9. [Unique Integers that Sum Up to 0](https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/) add 0 if number is odd
10. [698. Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/) backtrack
11. [55. Jump Game](https://leetcode.com/problems/jump-game/)
12. [1306. Jump Game III](https://leetcode.com/problems/jump-game-iii/) track visited index to avoid infinite loop
13. [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/) sort and Priority queue to track end time
14. [252. Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)
15. [1448. Count Good Nodes in Binary Tree](https://leetcode.com/problems/count-good-nodes-in-binary-tree/) recursive with bound
16. [Largest Alphabetic Character](https://www.geeksforgeeks.org/find-the-largest-alphabetic-character-present-in-the-string/) count freq, transverse from right side
17. [Given Two Arrays of Numerator and Denominator Pairs of Fractions sum up to 1 ](https://code.sololearn.com/c5192a3a20A1) 通分





```java
 public int findLCM(int [] arr){
        //find GCD for every two nums
        int gcd = arr[0], lcm = arr[0];
        for(int i = 1; i < arr.length - 1; i++){
            gcd = findGCD(arr[i], lcm);
            lcm = lcm * arr[i]/gcd;
        }
        return lcm;
    }

    public int findGCD(int a, int b){
        if(b == 0) return a;
        return findGCD(b, a%b);
    }
```



## March

======
Task 1
Find the bug(s) and modify one line code.
找一个array里面的最小值, 只要改初始值就可以了, 注意这里只能改一行.

======
Task 2
Write a function solution that, given an array A of N integers [-100, 100], returns the sign (-1, 0, 1) of all numbers in the array multiple together.
Assuming that N is between 1 and 1000.

For example, given A = [1,-2,-3,5], the function should return 1
Given A = [1,2,3,-5], your function should return -1
Given A = [1,2,0,-5], your function should return 0

======
Task 3 选择题一共10题

1. You are given 5 integers and your task is to find the smallest of them. What is the minimum number of comparisons that you have to make?
a. 3
**b. 4**
c. 5
d. 6

2. you are given an array with 10^8 elements and you must compute the sum A[j] + A[k] for every possible pair of elements in the array, How long will this computation take on a single mainstream computer?
a. milliseconds
b. seconds
c. minutes
d. hours
**e. more than few hours**

3. How do you check whether a number is odd in most programming languages?
a. if (x)
**b. if (x & 1)**
c. if ( x % 2 == 0)
d. if (x >> 1 == 0)

4. Given a sorted array, which of the following operations can be performed the fastest?
**a. checking whether the number 42 is in the array**
b. counting the number of different elements
c. computing the sum of all elements
d. all of the above operations are linear time, so they are approximately the same

5. A common data structure used to implement a relational database is a
a. queue
b. stack
c. priority-queue
**d. B-tree**

6. Given a list of 1000 elements, which of the following number is the largest
    a. the number of all possible subsets of a given list *<u>subset: combinations of elements, incluidng empty set, $2^n$</u>* 
    b. the number of all possible pairs of elements from a given list
    **c. the number of all possible permutations of a given list.  ** *<u>total length == original input order matters ABC VS ACB    $n!$</u>* 

  d. 10,000,000,000,000,000

7. Given a tree with 4 nodes, how many edges have to be added for it to cease being a tree?
    **a**. 1
    b. 2
    c. 3
    d. 4

8. which of the following statement is correct
    def f(A):
   for i := 0; i < A.length-1; i++  do:
       if (A > A[i+1]):
           swap A with A[i+1]

   return A

a. there is an element that can be removed so that f(A_without_one_element) returns a sorted array
**b. for any array of size N, f(A)[N-1] = max(A)**
c. for any array of size N, f(A)[0] = min(A)
d. more than one is correct

9. Wich of the following algorithm finds the shortest path in any unweighted graph?
a. DFS
**b. BFS**
c. both
d. neither

10. the time complexity of g(n, x, y) is O(n), what is the time complexity of f(n)
    def f(n):
    if n == 1:
        return 1
    x = f(n/2)
    y = f(n/2)
    return g(n, x, y)

a. O(logn)
b. O(n)
**c. O(nlog(n))**
d. O(n^2)

======
Task 4
LC 1448