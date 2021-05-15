# Graph

1. [1466. Reorder Routes to Make All Paths Lead to the City Zero](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/) bfs check neighbor



## Union find, disjoint set

**union find is good for**

+ find the cycle in graph
+ Group nodes

Every time we see relation is **transitive**, for example, <u>A and B are friend, B and C are friend, then A and C are friend, or A can reach B and B can reach C, then A can reach C as well,</u> In this case, we can use `union()` to group components with the same relations, and use `find()` to get the root (represent of the group) of two components to see if they are in the same group 

```java
public boolean UnionFind(List<List<String>> edges) {
        
    // union similar words into groups

    // parents array, m is total number of nodes
    int[] parents = new int[m];

    // negative indicates node i is the root (represent of the group)
    // and magnitude is the rank of the node (total number of nodes in the group)
    // if positive, it indicates the index of the parents
    Arrays.fill(parents, -1);
    // if the node is not number, we need to map word to ID
    Map<String, Integer> nodeToId = new HashMap<>();
    int id = 0;

    // loop each group and union similar component into a group
    for(List<String> edge : edges){
      union(edge.get(0), edge.get(1));
    }

    // now we have groups in which components share same relation or characteristics
    // do something specific
  
  
     private void union(int a, int b, int[] parents){
        int pa = find(a, parents);
        int pb = find(b, parents);
        if(pa == pb) return;// here is a cycle, since a and b are already in a group, but they share the same parent.
        if(Math.abs(parents[pa]) > Math.abs(parents[pb])){
            parents[pa] += parents[pb];
            parents[pb] = pa;
        }else if(Math.abs(parents[pa]) < Math.abs(parents[pb])){
            parents[pb] += parents[pa];
            parents[pa] = pb;
        }else{
            parents[pa] += parents[pb];
            parents[pb] = pa;
        }
    }
    
    private int find(int a, int[] parents){
        if(parents[a] < 0){// itself is the root;
            return a;
        }else{
            return find(parents[a], parents);
        }
    }
```



1. [721. Arrange Accounts](https://leetcode.com/problems/accounts-merge/solution/)
2. [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
3. [737. Sentence Similarity II](https://leetcode.com/problems/sentence-similarity-ii/)





## DFS  / Topological sorting

### DFS find Cycle in DAG (Directed Acylic Graph)

`visiting` state means a node A is being visiting, if later on we visit A again, which mean there is a cycle

```java
public boolean findCycle(int numCourses, int[][] prerequisites) {
        // use DFS to find the cycle
        // 0: unvisited, 1: visiting, 2: visited
        int[] state = new int[numCourses];
        List<List<Integer>> graph = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++){
            graph.add(new LinkedList<>());
        }
        
        for(int [] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        
        for(int i = 0; i < numCourses; i++){
            if(dfs(graph, i, state)){
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(List<List<Integer>> graph, int cur, int[] state){
        if(state[cur] == 1) return true;
        if(state[cur] == 2) return false;
        state[cur] = 1;
        for(int dependency : graph.get(cur)){
            if(dfs(graph, dependency, state)) return true;
        }
        state[cur] = 2;
        return false;
    }
```

### Top Sort

given a **directed acyclic graph (DAG)**, a topological sort is a linear ordering of all vertices such that for any edge `(u, v)`, `u` comes before `v`. Another way to describe it is that when you put all vertices horizontally on a line, all of the edges are pointing from left to right.

```java
public int[] findOrder(int numCourses, int[][] prerequisites) {
        // use topological sort 
        List<List<Integer>> graph = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new LinkedList<>());
        }
        
        for(int [] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] state = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(topoSort(graph, i, state, stack)){
                return new int[0];
            }; 
        }
        int[] ans = new int[numCourses];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }
    
    private boolean topoSort(List<List<Integer>> graph, int cur, int[] state, Stack<Integer> stack){
        // check if cur is visited
        if(state[cur] == 1) return true;
        if(state[cur] == 2) return false;
        state[cur] = 1;
        // explore all its child
        for(int child : graph.get(cur)){
            if(topoSort(graph, child, state, stack)){
                return true;
            };
        }
        // now all child of cur have been explored
        state[cur] = 2;
        stack.add(cur);
        return false;
    }
```



**Difference** with regular `DFS` is that Top sort return the sequence by pushing `curNode` into stack after it is fully explored (all its child are visited);

1. [207. Course Schedule  --  Medium](https://leetcode.com/problems/course-schedule/)

2. [210. Course Schedule II -- Medium](https://leetcode.com/problems/course-schedule-ii/)





## Floyd-Warshall Algorithm to find shortest distance between given two nodes in a graph

to find longest distance, just mutiply the weight with -1 then find shortest one.

<img src="images/image-20210505235623288.png" alt="image-20210505235623288" style="zoom:80%;" />

1. [1334. Find the City With the Smallest Number of Neighbors at a Threshold D -- Medium](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/)
2. [1462. Course Schedule IV -- Medium](https://leetcode.com/problems/course-schedule-iv/) boolean matrix



## Linear way

https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/TopologicalSortAdjacencyList.java

![image-20210511140144266](images/image-20210511140144266.png)

##  Eulerian Path / Circuits

**Eulerian Path**: a path of edges that <u>visits all the edges</u> in a graph <u>exactly once</u>.

**Eulerian Circuit**:  a Eulerian path starts and ends at the same vertex

![image-20210507145625398](images/image-20210507145625398.png)

And all vertices with non-zero degree need to belong to a single connected component

