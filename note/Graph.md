# Graph

1. [1466. Reorder Routes to Make All Paths Lead to the City Zero](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/) bfs check neighbor(only one way between different cities)



## BFS

**Every time see asking for Min cost/path/moves, should first think of the BFS**

**See BFS as a rada that sends the circle wave** 

**Bi-directional BSF can be used**

### General

1. [45. Jump Game II -- Medium](https://leetcode.com/problems/jump-game-ii/)
2. [909. Snakes and Ladders -- Medium](https://leetcode.com/problems/snakes-and-ladders/)
3. [127. Word Ladder -- Hard](https://leetcode.com/problems/word-ladder)
4. [126. Word Ladder II -- Hard](https://leetcode.com/problems/word-ladder-ii)
5. [130. Surrounded Regions -- Medium](https://leetcode.com/problems/surrounded-regions)
6. [200. Number of Islands -- Medium](https://leetcode.com/problems/number-of-islands)
7. [529. Minesweeper -- Medium](https://leetcode.com/problems/minesweeper)
8. [675. Cut Off Trees for Golf Event -- Hard](https://leetcode.com/problems/cut-off-trees-for-golf-event)
9. [785. Is Graph Bipartite? -- Medium](https://leetcode.com/problems/is-graph-bipartite)
10. [815. Bus Routes -- Hard](https://leetcode.com/problems/bus-routes/)
11. [838. Push Dominoes -- Medium](https://leetcode.com/problems/push-dominoes)
12. [928. Minimize Malware Spread II -- Hard](https://leetcode.com/problems/minimize-malware-spread-ii/)
13. [1036. Escape a Large Maze -- Hard](https://leetcode.com/problems/escape-a-large-maze) Bounded BFS
14. [1298. Maximum Candies You Can Get from Boxes -- Hard](https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes)
15. [1345. Jump Game IV -- Hard](https://leetcode.com/problems/jump-game-iv/)
16. [317. Shortest Distance from All Buildings -- Hard](https://leetcode.com/problems/shortest-distance-from-all-buildings)
17. [1905. Count Sub Islands -- Medium](https://leetcode.com/problems/count-sub-islands/)
18. [301. Remove Invalid Parentheses -- Hard](https://leetcode.com/problems/remove-invalid-parentheses/)
19. [987. Vertical Order Traversal of a Binary Tree --  Hard](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/)
20. [662. Maximum Width of Binary Tree --  Medium](https://leetcode.com/problems/maximum-width-of-binary-tree/)
21. [365. Water and Jug Problem -- Medium](https://leetcode.com/problems/water-and-jug-problem)
22. [749. Contain Virus -- Hard](https://leetcode.com/problems/contain-virus)
25. [1391. Check if There is a Valid Path in a Grid -- Medium](https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/) how do we check if directions match



### Reverse BFS (from dst to src / multi src)

1. [417. Pacific Atlantic Water Flow -- Medium](https://leetcode.com/problems/pacific-atlantic-water-flow/) 
2.  [407. Trapping Rain Water II -- Hard](https://leetcode.com/problems/trapping-rain-water-ii/)
2. [286. Walls and Gates -- Medium](https://leetcode.com/problems/walls-and-gates/)
2. [542. 01 Matrix -- Medium](https://leetcode.com/problems/01-matrix/)

### String/Bitmask to store the state/path

1. [773. Sliding Puzzle -- Hard](https://leetcode.com/problems/sliding-puzzle/)
2. [694. Number of Distinct Islands -- Medium](https://leetcode.com/problems/number-of-distinct-islands) path signature

### Bi-partition (coloring)

1. [886. Possible Bipartition -- Medium](https://leetcode.com/problems/possible-bipartition)
2. [785. Is Graph Bipartite? -- Medium](https://leetcode.com/problems/is-graph-bipartite)

### Find longest path in the Tree(Centroid of tree)

**Centroid** of the tree: nodes that is overall closest to all peripheral nodes (leaf nodes, the nodes have only one connection), **<u>there can be at most 2 centroids</u>** in a tree, since if there are 3, we can see two of them as leave and keep removing the outer layer, then the centroid becomes 1. If the left three nodes are not leaves, them they must form a cycle which conflicts with the definition. 

25. [1245. Tree Diameter -- Medium](https://leetcode.com/problems/tree-diameter/) furthest node of a random node is one of the extreme node

2. [310. Minimum Height Trees -- Medium](https://leetcode.com/problems/minimum-height-trees/) *****

3. [1617. Count Subtrees With Max Distance Between Cities -- Hard](https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/)

28. [543. Diameter of Binary Tree -- Easy](https://leetcode.com/problems/diameter-of-binary-tree/)

    

### Deque / Multiple States BFS

1. [1263. Minimum Moves to Move a Box to Their Target Location -- Hard](https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location)

   

### Visit repeatedly but with different state

1. [847. Shortest Path Visiting All Nodes -- Hard](https://leetcode.com/problems/shortest-path-visiting-all-nodes/) nodes and edges can be accessed multiple times, `state = {curNode, set of visited node}`, **bitmask**
2. [864. Shortest Path to Get All Keys -- Hard](https://leetcode.com/problems/shortest-path-to-get-all-keys)
3. [1293. Shortest Path in a Grid with Obstacles Elimination -- Hard](https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/)  BFS + DP
4. [787. Cheapest Flights Within K Stops -- Medium](https://leetcode.com/problems/cheapest-flights-within-k-stops/)
5. [1654. Minimum Jumps to Reach Home -- Hard](https://leetcode.com/problems/minimum-jumps-to-reach-home) right boundary

### Greedy

1. [854. K-Similar Strings -- Hard](https://leetcode.com/problems/k-similar-strings/)

### Dijkstra Algorithm (BFS + PriorityQueue)

**Resources**:

+ [Abdul Bari Youtube tutorial](https://www.youtube.com/watch?v=XB4MIexjvY0)

we can see the Dijkstra's algorithm as a **greedy** algorithm , every time after we relax a node, we go the node with min cost, and then relax that node, and so on.

<img src="images/image-20210609101046513.png" alt="image-20210609101046513" style="zoom:50%;" /><img src="images/image-20210609101025229.png" alt="image-20210609101025229" style="zoom:50%;" />

**Dijkstra is <u>NOT</u> friendly with negative cost**

![image-20210609101603063](images/image-20210609101603063.png)

[source code](https://leetcode.com/playground/93uryw5m)

```java
private int[] dijkstra(Map<Integer, List<int[]>> graph, int n, int start){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> settled = new HashSet<>();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // start point is 0
        queue.offer(new int[]{start, 0});
        distance[start] = 0;
        while(settled.size() != n){
            int[] cur = queue.poll(); // pick up the node with min cost
            settled.add(cur[0]);
            relax(graph, settled, queue, distance, cur[0]);
        }
        return distance;
    }
    private void relax(Map<Integer, List<int[]>> graph, Set<Integer> settled, PriorityQueue<int[]> queue, int[] distance, int cur){
       
        if(graph.get(cur) ==  null) return;
        for(int[] nei : graph.get(cur)){
            int to = nei[0];
            int cost = nei[1];
            if(!settled.contains(to) && distance[cur] + cost < distance[to]){
                distance[to] = distance[cur] + cost;
                queue.offer(new int[]{to, distance[to]});
            }
        }
    }
```

**Questions:** 

1. [505. The Maze II --  Medium](https://leetcode.com/problems/the-maze-ii/)
2. [882. Reachable Nodes In Subdivided Graph](https://leetcode.com/problems/reachable-nodes-in-subdivided-graph)
3. [1928. Minimum Cost to Reach Destination in Time -- Hard](https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time)
4. [778. Swim in Rising Water -- Hard](https://leetcode.com/problems/swim-in-rising-water/)
5. [407. Trapping Rain Water II -- Hard](https://leetcode.com/problems/trapping-rain-water-ii/)
6. [42. Trapping Rain Water -- Hard](https://leetcode.com/problems/trapping-rain-water/)
7. [1631. Path With Minimum Effort -- Medium](https://leetcode.com/problems/path-with-minimum-effort)
8. [743. Network Delay Time -- Medium](https://leetcode.com/problems/network-delay-time)
9. [1102. Path With Maximum Minimum Value -- Medium](https://leetcode.com/problems/path-with-maximum-minimum-value/) cannot use DFS+Memo, since it goes four directions
10. [1129. Shortest Path with Alternating Colors -- Medium](https://leetcode.com/problems/shortest-path-with-alternating-colors/)
10. [787. Cheapest Flights Within K Stops -- Medium](https://leetcode.com/problems/cheapest-flights-within-k-stops)
10. [778. Swim in Rising Water -- Hard](https://leetcode.com/problems/swim-in-rising-water)

### Other

1. [1654. Minimum Jumps to Reach Home -- Meidum](https://leetcode.com/problems/minimum-jumps-to-reach-home/) `ax + by = z`, z must be `z = n * gcd(a, b)`, that means all reachable points must be mulitples of gcd(a, b)
2. [1871. Jump Game VII -- Medium](https://leetcode.com/problems/jump-game-vii/) tricky way to avoid processing same position



## DFS

### 	General

1. [652. Find Duplicate Subtrees -- Medium](https://leetcode.com/problems/find-duplicate-subtrees/) Does null need to be included? Inorder or postorder
2. [1048. Longest String Chain -- Medium](https://leetcode.com/problems/longest-string-chain/)



### DFS find Cycle in DAG (Directed Acyclic Graph)

`visiting` state means a node A is being visiting, if later on we visit A again, which mean there is a cycle

if **Undirected**, we need to track node visited in the previous step

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

1. [1559. Detect Cycles in 2D Grid -- Medium](https://leetcode.com/problems/detect-cycles-in-2d-grid/)
2. [457. Circular Array Loop --  Medium](https://leetcode.com/problems/circular-array-loop/)

### Find separate group by DFS

1. [323. Number of Connected Components in an Undirected Graph -- Medium](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
2. [1059. All Paths from Source Lead to Destination](https://leetcode.com/problems/all-paths-from-source-lead-to-destination/) detect cycle in defined paths

### Top Sort

**Difference** with regular `DFS` is that Top sort return the sequence by pushing `curNode` into stack after it is fully explored (all its child are visited);

1. [207. Course Schedule  --  Medium](https://leetcode.com/problems/course-schedule/)

2. [210. Course Schedule II -- Medium](https://leetcode.com/problems/course-schedule-ii/)

3. [269. Alien Dictionary -- Hard](https://leetcode.com/problems/alien-dictionary/)

   

## Union find, disjoint set

**union find is good for**

+ find the cycle in graph
+ Group nodes

Every time we see relation is **transitive, merge, divide into different groups**, for example, <u>A and B are friend, B and C are friend, then A and C are friend, or A can reach B and B can reach C, then A can reach C as well,</u> In this case, we can use `union()` to group components with the same relations, and use `find()` to get the root (represent of the group) of two components to see if they are in the same group 

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
      union(parents, edge.get(0), edge.get(1));
    }

    // now we have groups in which components share same relation or characteristics
    // do something specific
  
  
     private boolean union(int[] parents, int a, int b){
        int pa = find(parents, a);
        int pb = find(parents, b);
        if(pa == pb) return false;// here is a cycle, since a and b are already in a group, but they share the same parent.
       if(Math.abs(parents[pa]) >= Math.abs(parents[pb])){
            parents[pa] += parents[pb];
            parents[pb] = pa;
        }else{
            parents[pb] += parents[pa];
            parents[pa] = pb;
        }
         return true;
    }
    
    private int find(int[] parents, int a){
        if(parents[a] < 0){// itself is the root;
            return a;
        }else{
            return find(parents, parents[a]);
        }
    }
```

### General

1. [721. Arrange Accounts](https://leetcode.com/problems/accounts-merge/solution/)
2. [547. Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
3. [737. Sentence Similarity II](https://leetcode.com/problems/sentence-similarity-ii/)
4. [565. Array Nesting -- Medium](https://leetcode.com/problems/array-nesting)
5. [924. Minimize Malware Spread -- Hard](https://leetcode.com/problems/minimize-malware-spread/)
6. [323. Number of Connected Components in an Undirected Graph -- Medium](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
7. [1319. Number of Operations to Make Network Connected -- Medium](https://leetcode.com/problems/number-of-operations-to-make-network-connected)
8. [684. Redundant Connection -- Medium](https://leetcode.com/problems/redundant-connection/)
9. [685. Redundant Connection II -- Hard](https://leetcode.com/problems/redundant-connection-ii)
9. [952. Largest Component Size by Common Factor -- Hard](https://leetcode.com/problems/largest-component-size-by-common-factor/)
9. [352. Data Stream as Disjoint Intervals  --  Hard](https://leetcode.com/problems/data-stream-as-disjoint-intervals/)

### View cells in matrix as vertices 

1. [200. Number of Islands -- Medium](https://leetcode.com/problems/number-of-islands/)
2. [827. Making A Large Island -- Hard](https://leetcode.com/problems/making-a-large-island/), to group distinct islands
3. [959. Regions Cut By Slashes -- Medium](https://leetcode.com/problems/regions-cut-by-slashes/)
4. [947. Most Stones Removed with Same Row or Column -- Medium](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/)
5. [128. Longest Consecutive Sequence -- Medium](https://leetcode.com/problems/longest-consecutive-sequence/) apply union find 
6. [Is Graph Bipartite? -- Medium](https://leetcode.com/problems/is-graph-bipartite)
7. [130. Surrounded Regions -- Medium](https://leetcode.com/problems/surrounded-regions)
8. [1254. Number of Closed Islands -- Medium](https://leetcode.com/problems/number-of-closed-islands)

### View row and col as vertex

10. [1632. Rank Transform of a Matrix --  Hard](https://leetcode.com/problems/rank-transform-of-a-matrix)

### Weighted union and find

1. [399. Evaluate Division -- Medium](https://leetcode.com/problems/evaluate-division/)
2. [990. Satisfiability of Equality Equations -- Medium](https://leetcode.com/problems/satisfiability-of-equality-equations/)


### Cyclic Swapping

1. [765. Couples Holding Hands -- Hard](https://leetcode.com/problems/couples-holding-hands)



## Find shortest distance between given two nodes in a graph

### [Floyd-Warshall Algorithm](https://www.youtube.com/watch?v=oNI0rf2P9gE) 

to find longest distance, just multiply the weight with -1 then find shortest one.

<img src="images/image-20210505235623288.png" alt="image-20210505235623288" style="zoom:80%;" />

1. [1334. Find the City With the Smallest Number of Neighbors at a Threshold D -- Medium](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/)
2. [1462. Course Schedule IV -- Medium](https://leetcode.com/problems/course-schedule-iv/) boolean matrix



### Linear way

https://github.com/williamfiset/Algorithms/blob/master/src/main/java/com/williamfiset/algorithms/graphtheory/TopologicalSortAdjacencyList.java

![image-20210511140144266](images/image-20210511140144266.png)

##  Eulerian Path / Circuits

**Eulerian Path**: a path of edges that <u>visits all the edges</u> in a graph <u>exactly once</u>.

**Eulerian Circuit**:  a Eulerian path starts and ends at the same vertex

![image-20210507145625398](images/image-20210507145625398.png)

And all vertices with non-zero degree need to belong to a single connected component



## Tarjan Algorithm: find the bridge of the graph

**basic idea: give the label/rank to each node when dfs, the rank should increase, there is a cycle if the rank goes down during dfs ( since if there is no cycle, the min rank in the later path should be at least larger than the current node's rank) , and all nodes with lower ranks than the current node' rank  are part of cycle**

```java
public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // make graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Pair<Integer, Integer>> uniqueC = new HashSet<>();
        for(List<Integer> connection : connections){
            map.computeIfAbsent(connection.get(0), x->new ArrayList<>()).add(connection.get(1));
            map.computeIfAbsent(connection.get(1), x->new ArrayList<>()).add(connection.get(0));
            uniqueC.add(new Pair<Integer, Integer>(Math.min(connection.get(0), connection.get(1)), Math.max(connection.get(0), connection.get(1))));
        }
        int[] rank = new int[n];
        Arrays.fill(rank, -1); // -1 means not visited
        // dfs if cur rank is smaller than the prev rank, cycle
        dfs(map, rank, uniqueC, 0, -1, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(Pair<Integer,Integer> a : uniqueC){
            List<Integer> temp = new ArrayList<>();
            temp.add(a.getKey());
            temp.add(a.getValue());
            ans.add(temp);
        }
        return ans;
    }
    private int dfs(Map<Integer, List<Integer>> map, int[] rank, Set<Pair<Integer, Integer>> uniqueC, int cur, int prev, int curRank){
        if(rank[cur] >= 0) return rank[cur];// go back visit a node twice, cycle
        rank[cur] = curRank;
        int minRank = Integer.MAX_VALUE;
        for(int nei : map.get(cur)){
            if(nei == prev) continue;
            int nextRank = dfs(map, rank, uniqueC, nei, cur, curRank + 1);
            if(rank[cur] >= nextRank) uniqueC.remove(new Pair<Integer, Integer>(Math.min(nei, cur), Math.max(nei, cur)));
            minRank = Math.min(minRank, nextRank);
        }
        return minRank;
    }
```



1. [1192. Critical Connections in a Network -- Hard](https://leetcode.com/problems/critical-connections-in-a-network/)

   

## Kruskal Algorithm: find minimum <u>Spanning Tree</u>

**MST**: A **minimum spanning tree** (**MST**) or **minimum weight spanning tree** is a subset of the edges of a [connected](https://en.wikipedia.org/wiki/Connected_graph), edge-weighted undirected graph that connects all the [vertices](https://en.wikipedia.org/wiki/Vertex_(graph_theory)) together, without any [cycles](https://en.wikipedia.org/wiki/Cycle_(graph_theory)) and with the minimum **possible total edge weight**, if all N nodes are connected, MST will have N - 1 edges

[**Video link**](https://www.youtube.com/watch?v=4ZlRH0eK-qQ)

+ sort edges based on weight in non-decreasing order
+ loop through each edge, check two nodes connected by that edge are in the same group, if **yes**, that means node1 can access the node2 from other path which is accessed before (since the edge is sorted by weight in non-decreasing order, the earlier path costs less), ignore this edge. if **no**,  and union two nodes and add the edge into the spanning tree set.

1. [1135 Connecting Cities With Minimum Cost -- Medium](https://leetcode.com/problems/connecting-cities-with-minimum-cost/)
2. [1168. Optimize Water Distribution in a Village -- Hard](https://leetcode.com/problems/optimize-water-distribution-in-a-village/)



**[Code Template](https://leetcode.com/playground/new/empty)**

```java
 public int minimumCost(int n, int[][] connections) {
        // kruskal, always choose the mincost edge
   			// if make a cycle, ingonre it, since cheaper edge counted earlier 
        int[] parent = new int[n + 1];
        int ans = 0, connectedEdges = 0;
        Arrays.fill(parent, -1);
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        for(int[] connection : connections){
            int p1 = find(connection[0], parent);
            int p2 = find(connection[1], parent);
            if(p1 == p2) continue;
            union(connection[0], connection[1], parent);
            ans += connection[2];
            connectedEdges ++;
        }
        if(connectedEdges == n - 1){
            return ans;
        }else{
            return -1;
        }
    }
    
    private boolean union(int a, int b, int[] parent){...}
    
    private int find(int a, int[] parent){...}
```



### Multi-threading

1. [1242. Web Crawler Multithreaded -- Medium](https://leetcode.com/problems/web-crawler-multithreaded/)



## to be categorized

1. [1761. Minimum Degree of a Connected Trio in a Graph -- Hard](https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/)

2. [834. Sum of Distances in Tree -- Hard](https://leetcode.com/problems/sum-of-distances-in-tree/)

