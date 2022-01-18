# Algorithm with names

## Profile the boundaries

### Jarvis Algorithm

**[YouTube](https://www.youtube.com/watch?v=Vu84lmMzP2o)** **[source code](https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/JarvisMarchConvexHull.java)**

1. [587. Erect the Fence -- Hard](https://leetcode.com/problems/erect-the-fence/)





## Moore Voting

to find the majority element in a collection. Basic idea is that the majority element cannot be balanced out, e.g  [2, 1, 1, 2, 2,]

at the begining, 2 is balanced out by 1, then 1 becomes the candidate, but later on the 1 is balanced out by 2, and voting, there is some 2 left

which means 2 is majority

```java
public int majorityElement(int[] nums) {
	int candidate = nums[0], count = 1;
  for(int i = 1; i < nums.length; i++){
    if(count == 0){
      // change candidate
      candidate = nums[i];
    }
    count += nums[i] == candidate ? 1 : -1;
  }
  return candidate;
}
```

1. [169. Majority Element -- Easy](https://leetcode.com/problems/majority-element/)
2. [229. Majority Element II -- Medium](https://leetcode.com/problems/majority-element-ii/)
