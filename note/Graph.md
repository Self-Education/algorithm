## Graph

1. [1466. Reorder Routes to Make All Paths Lead to the City Zero](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/) bfs check neighbor



## Union find, disjoint set

**union find is good for**

+ find the cycle in graph
+ Group nodes

Every time we see relation is **transitive**, for example, <u>A and B are friend, B and C are friend, then A and C are friend, or A can reach B and B can reach C, then A can reach C as well,</u> In this case, we can use `union()` to group components with the same relations, and use `find()` to get the root (represent of the group) of two components to see if they are in the same group 

```java
public boolean UnionFind(List<List<String>> input) {
        
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
    for(List<String> components : input){
      // use the first element as the represent of the group
      String represent = components.get(1);
      if(!nodeToId.containsKey(represent)){
        nodeToId.put(represent,id++);
      };
      for(int i = 2; i < components.size(); i++){
        String compo = components.get(i);
        if(!nodeToId.containsKey(compo)){
          nodeToId.put(compo,id++);
        };
        union(nodeToId.get(represent), nodeToId.get(compo), parents);
      }
    }

    // now we have groups in which components share same relation or characteristics
    // do something specific
  
  
     private void union(int a, int b, int[] parents){
        int pa = find(a, parents);
        int pb = find(b, parents);
        if(pa == pb) return;
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

