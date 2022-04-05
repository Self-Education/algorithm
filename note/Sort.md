# Sort



## Bubble Sort

1. [1536. Minimum Swaps to Arrange a Binary Grid -- Medium](https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid)

## Bucket Sort

### Problems

set the size of bucket 

1. [164. Maximum Gap -- Hard](https://leetcode.com/problems/maximum-gap)





## Merge Sort





### Problems



## Merge/Insert Intervals

if there are two dimensions, sort based on one dimension, to reduce possible cases



#### Sort by start point: find the minimum number of intervals to cover the whole range

1. [Merge Intervals -- Medium](https://leetcode.com/problems/merge-intervals/) Sort based on one dimension, to reduce possible cases

2. [SkyLine]

3. Meeting 

4. Meeting II

5. [252. Meeting Rooms -- Easy](https://leetcode.com/problems/meeting-rooms)

6. [1326. Minimum Number of Taps to Open to Water a Garden -- Hard](https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/)

7. [1024. Video Stitching -- Medium](https://leetcode.com/problems/video-stitching/)

8. [986. Interval List Intersections -- Medium](https://leetcode.com/problems/interval-list-intersections/)

9. [763. Partition Labels --  Medium](https://leetcode.com/problems/partition-labels)

10. [1229. Meeting Scheduler -- Medium](https://leetcode.com/problems/meeting-scheduler)

11. [57. Insert Interval -- Medium](https://leetcode.com/problems/insert-interval/)

12. [616. Add Bold Tag in String -- Medium](https://leetcode.com/problems/add-bold-tag-in-string/)

    

#### Sort by end point: maximum number of non-overlapping intervals

sort the intervals by the end points ascendingly, if multiple intervals overlapped, we greedily choose the one with the  smallest end point to reduce the affect on the rest of intervals

1. [435. Non-overlapping Intervals -- Medium](https://leetcode.com/problems/non-overlapping-intervals)
2. [452. Minimum Number of Arrows to Burst Balloons -- Medium](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons)
3. [2054. Two Best Non-Overlapping Events -- Medium](https://leetcode.com/problems/two-best-non-overlapping-events/)
4. [646. Maximum Length of Pair Chain -- Medium](https://leetcode.com/problems/maximum-length-of-pair-chain/)

#### Sweeping line: good for multiple lines overlapping, how many events at certain time spot

## Use comparator directly 

(if logic is complicated, then compare different cases directly)

1. [179. Largest Number -- Medium](https://leetcode.com/problems/largest-number/) just `String case1 = a + b; String case2 = b + a; return case2.compareTo(case1);`
2. [1366. Rank Teams by Votes -- Medium](
3. [1333. Filter Restaurants by Vegan-Friendly, Price and Distance -- Medium](https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/)



## Other

1. [274. H-Index --  Medium](https://leetcode.com/problems/h-index)
2. [1509. Minimum Difference Between Largest and Smallest Value in Three Moves -- Medium](https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves)
3. 
4. [2007. Find Original Array From Doubled Array -- Medium](https://leetcode.com/problems/find-original-array-from-doubled-array/)
4. [954. Array of Doubled Pairs -- Medium](https://leetcode.com/problems/array-of-doubled-pairs)
5.  [1509. Minimum Difference Between Largest and Smallest Value in Three Moves -- Medium](https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves)
6. [1329. Sort the Matrix Diagonally -- Medium](https://leetcode.com/problems/sort-the-matrix-diagonally/)
6. [1968. Array With Elements Not Equal to Average of Neighbors -- Medium](https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/)

