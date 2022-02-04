# Backtracking

## General

1. [425. Word Squares -- Hard](https://leetcode.com/problems/word-squares/)

## Permutation vs Combination vs Subset

+ **Subset**: pick any number of element from a collections, for `[0, 1, 2, 3]`, subset could be picking up 0 element, `[]`, or pick up 1 element `[1]`, `[2]` , .. or picking up 2 element `[0, 1]`, `[1,3]`... , $2^n$
+ **Combinations**: similar with subset, but no empty subset and normally has requirement on the length of combinations $C_N^k = \frac{N!}{(N - K)!K!} = \frac{N * (N- 1) * ... * (N - K + 1)}{K!} = \frac{P_N^K}{K!}$
+ **Permutation**: not pick-up, rearrange order of elements $P_N^k = \frac{N!}{(N - K)!} = N * (N- 1) \ * \  ... \ * (N - K + 1)$

1. ### [77. Combinations](https://leetcode.com/problems/combinations/) 

   **`loop from index + 1`**, each element can only be used once, if change it into` backtrack(..., i )`, then element can be used multiple times, but also prevent same sequence.

   ```java
    public void backTrack(int[] nums, int start, List<Integer> list,List<List<Integer>> res){
           if(list.size() == k){
               res.add(new LinkedList<>(list));
               return;
           }
           for(int i = start; i < n + 1 ; i ++){
               list.add(nums[i]);
               backTrack(nums, i + 1, list, res);
               list.remove(list.size() - 1);
           }
       }
   ```

   

2. ### Combination with duplicates

   ```java
    public void backTrack(int[] nums, int start, List<Integer> list,List<List<Integer>> res){
           if(list.size() == k){
               res.add(new LinkedList<>(list));
               return;
           }
           for(int i = start; i < n + 1 ; i ++){
               if(i != start && nums[i - 1] == nums[i] ) continue;
               list.add(nums[i]);
               backTrack(nums, i + 1, list, res);
               list.remove(list.size() - 1);
           }
       }
   ```

   

3. ### [46. Permutations](https://leetcode.com/problems/permutations/) 

   **`int[] visited + loop from 0`**

   `visited` ensure each element can only be used once

   ```java
   public void backtrack(int[] nums, LinkedList<Integer> cur){
           if(cur.size() == nums.length){
               res.add(new LinkedList<Integer>(cur));
               return;
           }
          	// choose from entire collection for dirrerent order
           for(int i = 0; i < nums.length; i++){
               if(!visited.contains(nums[i])){
                   cur.add(nums[i]);
                   visited.add(nums[i]);
                   backtrack(nums, cur);
                   cur.removeLast();
                   visited.remove(nums[i]);
               }
   
           }
           
       }
   ```

   

4. ### [47. Permutations II](https://leetcode.com/problems/permutations-ii/) 

   duplicates in the collections but to get unique permutations

   **`sort + int[] visited + loop from 0 + only use the first element in a group of duplicates`**

   for `a a b b c`, after choosing the first `a` as the first element to the first permutation `a a b b c`, 

   we can not use the second `a` as the first element or we will get the duplicate permutation. So we can only use the first element of the group duplicates ( after sorting) as the first element in that stack

   eg. use `a` for the first element, then permeate `a b b c`. **visited** stores indices

   ```java
    private void backtrack(int[] nums, int[] visited, List<Integer> list, List<List<Integer>> ans){
           // base case
           if(list.size() ==  nums.length){
               ans.add(new LinkedList<>(list));
               return;
           }
           for(int i = 0; i < nums.length; i++){
               if(visited[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) continue;
              
               visited[i] = 1;
               list.add(nums[i]);
               backtrack(nums, visited, list, ans);
               list.remove(list.size() - 1);
               visited[i] = 0;
           }
       }
   ```

   or use `HashMap`, so that we only use the unique number for the first element in its current stack

   ```java
   public List<List<Integer>> permuteUnique(int[] nums) {
           occurence = new HashMap<>();
           res = new LinkedList<>();
           for(int num : nums){
               occurence.put(num, occurence.getOrDefault(num, 0) + 1);
           }
           backtrack(nums, new LinkedList<Integer>());
           return res;
   } 
   
   public void backtrack(int nums[], LinkedList<Integer> cur){
           if(cur.size() == nums.length){
               res.add(new LinkedList<Integer>(cur));
               return;
           }
           for(int key : occurence.keySet()){
               if(occurence.get(key) != 0){
                   cur.add(key);
                   occurence.put(key, occurence.get(key) - 1);
                   backtrack(nums, cur);
                   cur.removeLast();
                   occurence.put(key, occurence.get(key) + 1);
               }            
           }
   
       }
   ```

   

5. [518. Coin Change 2 -- Medium](https://leetcode.com/problems/coin-change-2/) unbound, eliminate duplicates

6. [39. Combination Sum -- Medium](https://leetcode.com/problems/combination-sum/) same with question above, but different way to avoid duplicates

7. [40. Combination Sum II -- Medium](https://leetcode.com/problems/combination-sum-ii)

8. [78. Subsets -- Medium](https://leetcode.com/problems/subsets)

8. [254. Factor Combinations -- Medium](https://leetcode.com/problems/factor-combinations/)





## Palindrome Partitioning (backtracking + memoization)

Refer to **<u>Dynamic programming.md</u>** -> **<u>Palindrome Partitioning (backtracking + memoization)</u>**



## use String store state

1. [37. Sudoku Solver -- Hard](https://leetcode.com/problems/sudoku-solver)

## Pick or not

[320. Generalized Abbreviation -- Medium](https://leetcode.com/problems/generalized-abbreviation/) actually DFS

[784. Letter Case Permutation --  Medium](https://leetcode.com/problems/letter-case-permutation/)

[909. Snakes and Ladders -- Medium](https://leetcode.com/problems/snakes-and-ladders/)





## Strobogrammatic Number

1. [247. Strobogrammatic Number II -- Medium](https://leetcode.com/problems/strobogrammatic-number-ii)
2. [248. Strobogrammatic Number III -- Hard](https://leetcode.com/problems/strobogrammatic-number-iii)







```js
const PrivateRoute = ({component, isAuthenticated, ...rest}) =>{ // line 0
    const routeComponent = (props) => {...} // line 1
    return <Route render={routeComponent} {...rest}> // line 2
}
    /*
    请问这三个圆圈里，第一个…rest是啥，
    	lets say in the another file, layout.js,  we are using <PrivateRoute/> like this
    	<PrivateRoute
				path="..."
				porp1={...}
				prop2={...}
				isAuthenticated={...}
				component={MyComponent}
		/>
        PrivateRoute = ({component, isAuthenticated, ...rest}), here you are deconstructing props, the props 		here are {path, prop1, prop2, component, isAuthenticated}, ... rest holds rest of props expcet for 		ones you specified (component and isAuthenticated)
        
	然后为什么要return 一个 react.createElement
		react.createElement(component, props) creates a new element that bind props with the component (which is MyComponent) , and you sign this element int 'routeCompomnent' for feature use. in your case, you will render it in the Route at the line 2
		
	然后最后Route render 为什么要渲染，然后又传一遍 … rest	
    	Route normally can be used in two ways:
    	1. <Route path="..." component={} />
    	2. <Route {...rest}  render={(props) => <Component {...props} />}/>
    	
    	here you are using the second way, ...rest here just brings all props into the new Route, in your case, you can see it as <Route path="..." porp1={...} prop2={...}, render={} />
    	
    	the 'props' inside the render function are the props inside compoment (MyComponent, in your case), you have already combined the component with props, so you can just use <Route {...rest} render={component}>
    />
    */
```

