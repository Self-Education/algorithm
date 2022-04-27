## OA

1. given an int array including zero, return the sign of the product

2. .Given an non-decreasing array A, and integer K, find and correct bugs in a function that checks whether A contains numbers 1, 2, ..., K and no other numbers.

3. ![img](https://oss.1point3acres.cn/forum/202204/11/105511a1eged54pskskxt6.png)

    https://www.1point3acres.com/bbs/thread-882811-1-1.html

4. [1386. Cinema Seat Allocation](https://leetcode.com/problems/cinema-seat-allocation/)

5. The algorithm takes in input a vector of integer sorted in a non-decreasing order and an integer K. The algorithm returns true if the vector contains only and all the numbers between 1 and k at least once, and false otherwise:

    ([1,1,2,3,3,4],4) --> true

    ([1,1,3],3) --> false

6. 给一个字符串，拆成多个 subString，每个substring 不能有重复字母，问能拆成几个 substring。
    string "world"，return 1；
    string "dddd"，return 4；
    string "abba"，return 2。

7.  给 A 和 B 两个长度都是 N 的数组，返回 fair index 的个数。每个数组从 index K 劈成两部分，四部分的和相等，K 就是 fair index。
    sum(A[0]+A[1] + …… + A[K-1]),
    sum(A[K] + A[K+1] + …… + A[N-1]),
    sum(B[0]+B[1] + …… + B[K-1]),
    sum(B[K] + B[K+1] + …… + B[N-1]) 这四个 sum 相等。
    A = [A0, A1, A2, A3]
    B = [B0, B1, B2, B3]
    如果 A0 + A1 = A2 + A3 = B0 + B1 = B2 + B3，2 就是 fair index
    Example：
    A = [0, 4, -1, 0, 3]，B = [0, -2, 5, 0, 3]，有 3 和 4 两个 fair index，所以 return 2；
    A = [2, -2, -3, 3]，B = [0, 0, 4, -4]，只有 2 一个 fair index，所以 return 1；
    A = [4, -1, 0, 3]，B = [-2, 6, 0, 4]，没有 fair index，所以 return 0；
    A = [3, 2, 6]，B = [4, 1, 6]， return 0；
    A = [1, 4, 2, -2, 5]‍‌‍‌‌‍‍‌‍‍‌‍‍‍‌‌‍‍‌，B = [7, -2, -2, 2, 5] 有 2 和 4 两个 fair index，return 2。

8. given a string S, which consists entirely of decimal digits (0−9). Use digits from s to form a max palindromic number. "39878" -> "898"; "00900" -> "9"

9. 把一个string中相邻并重复的字母删掉，不同位置的花费不同，求最小花费。例如：“aabbcc"和[$1,$2,$1,$2,$1,$2]，删城”ABC"，花费￥3；“aaaa"和【$3,$4，￥5，￥6】，删掉前三个A，花费￥3+4+5

10. [1775. Equal Sum Arrays With Minimum Number of Operations](https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/)

11. 给一个字符串, 只包含A, B ,写一个函数处理这个字符‍‍‌‌‌‍‍‌‍‍‌‌‌‌‌‍‍‌‍串, 使这个字符串成为左边全是A，右边全是B， 或者整个字符串都是A或者都是B，使用delete方法。 如S＝“BAAABAB”， 应该返回2， 删除第一个出现的B与最后出现的A。但还有个要求是删除字母数需要最少

12. 是输入一个int数组，每个数表示这个数所在位置的高度，然后需要横着把这些类似矩形图用笔刷都画到
    比如【1，1，1，1】，横着一笔就可以画完
    【6，3】这种，一共需要6笔画完，因为每一笔的高度为一
    【6，3，5】这种，因为第二个矩形高度是三，中间断开不能一笔画完，所以一‍‌‍‌‌‍‍‌‍‍‌‍‍‍‌‌‍‍‌共需要八笔画完

13. given a number, remove one 5 to get largest number

    ![img](https://oss.1point3acres.cn/forum/202204/21/021548a0r629wqvvqf6rvr.png)
