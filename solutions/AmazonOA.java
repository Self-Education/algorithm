import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.lang.String;

public class AmazonOA {

    /*
     * find the highest profit
     */
    public int findHighestProfit(List<Integer> inventory, int order) {
        // todo edge cases:
        if (order == 0 || inventory.size() == 0)
            return 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0;
        for (int inven : inventory) {
            queue.offer(inven);
        }
        while (order > 0 && !queue.isEmpty()) {
            int cur = queue.poll();
            ans += cur;
            cur--;
            queue.offer(cur);
            order--;
        }
        return ans;
    }

    /*
     * items in containers, * | * * | * * |
     */
    public List<Integer> itemInContainers(String s, int[][] ranges) {
        // for each start index,, we need to find closest | on its right sie
        // for each end index, we need to find the closest | on its left side

        int m = s.length();
        // left bound
        int[] leftBounds = new int[m];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                leftBounds[i] = i;
            } else {
                leftBounds[i] = i == 0 ? -1 : leftBounds[i - 1];
            }
        }

        int[] rightBounds = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                rightBounds[i] = i;
            } else {
                rightBounds[i] = i == m - 1 ? -1 : rightBounds[i + 1];
            }
        }
        // prefix
        int count = 0;
        int[] prefix = new int[m];
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '*') {
                count++;
            } else {
                prefix[i] = count;
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (int[] range : ranges) {
            int start = rightBounds[range[0]];
            int end = leftBounds[range[1]];
            if (start != -1 && end != -1 && start <= end) {
                ans.add(prefix[end] - prefix[start]);
            } else {
                ans.add(0);
            }
        }
        return ans;
    }

    /*
     * Optimal Utilization
     */
    // public List<int[]> optimalUtilization(List<int[]> a, List<int[]> b, int
    // target) {

    // // two pointers
    // Collections.sort(a, (m, n) -> m[1] - n[1]);
    // Collections.sort(a, (m, n) -> m[1] - n[1]);

    // int p1 = 0, p2 = b.size() - 1, max = Integer.MIN_VALUE;
    // List<int[]> ans = new LinkedList<>();
    // while (p1 < a.size() && p2 >= 0) {
    // int sum = a.get(p1)[1] + b.get(p2)[1];
    // if (sum > target) {
    // // move p2 toward left to lower the sum
    // p2--;
    // } else {// sum < target, we can move p1 to right to increase p2
    // if (sum < max)
    // continue;

    // if (sum > max) { // previous list with sum == max should be discarded
    // max = sum;
    // ans.clear();
    // }
    // ans.add(new int[] { a.get(p1)[0], b.get(p2)[0] });
    // // handle duplicates
    // int k = p2 - 1;
    // while (k >= 0 && b.get(k)[1] == b.get(p2)[1]) {
    // ans.add(new int[] { a.get(p1)[0], a.get(k)[0] });
    // }
    // p1++;
    // }
    // }
    // return ans;
    // }

    public List<int[]> optimalUtilization(int[][] a, int[][] b, int target) {
        // edge cases:
        int m = a.length, n = b.length;
        if (m == 0 || n == 0)
            return null;
        Arrays.sort(a, (a1, a2) -> a1[1] - a2[1]);
        Arrays.sort(b, (b1, b2) -> b1[1] - b2[1]);
        int p1 = 0, p2 = n - 1;
        List<int[]> ans = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        while (p1 < m && p2 >= 0) {
            int num1 = a[p1][1];
            int num2 = b[p2][1];
            if (num1 + num2 > target) {
                p2--;
            } else {
                if (num1 + num2 < max)
                    continue;
                if (num1 + num2 > max) {
                    max = num1 + num2;
                    ans.clear();
                }
                ans.add(new int[] { a[p1][0], b[p2][0] });
                p1++;
            }
        }
        return ans;
    }

    /*
     * cost evaluation
     */
    public int costEvaluation(int n, int[][] connections) {
        // edge case
        if (n == 0)
            return 0;

        // union find to group warehouses
        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        for (int[] connection : connections) {
            int w1 = connection[0];
            int w2 = connection[1];
            union(w1, w2, parents);
        }

        // search parents, the represent of group is negative, magnitude is total
        // memebers in that group
        int ans = 0;
        for (int node : parents) {
            if (node < 0) {
                ans += Math.ceil(Math.sqrt(Math.abs(node)));
            }
        }
        return ans;
    }

    private boolean union(int a, int b, int[] parents) {
        int pa = find(a, parents);
        int pb = find(b, parents);
        if (pa == pb)
            return false;
        if (Math.abs(parents[pa]) > Math.abs(parents[pb])) {
            parents[pa] += parents[pb];
            parents[pb] = pa;
        } else if (Math.abs(parents[pa]) < Math.abs(parents[pb])) {
            parents[pb] += parents[pa];
            parents[pa] = pb;
        } else {
            parents[pa] += parents[pb];
            parents[pb] = pa;
        }
        return true;
    }

    private int find(int a, int[] parents) {
        if (parents[a] < 0) {
            return a;
        }
        return find(parents[a], parents);
    }

    /*
     * Movies on flights, similar with optimal utilization/ Prime air time
     */
    public int[] moviesOnFlight(int[] durations, int d) {
        // edge cases
        if (d == 0 || durations.length == 0)
            return new int[2];

        // store index of each movie
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < durations.length; i++) {
            map.computeIfAbsent(durations[i], x -> new LinkedList<>()).add(i);
        }

        // sort and two pointers
        Arrays.sort(durations);
        int target = d - 30;
        int p1 = 0, p2 = durations.length - 1, max = Integer.MIN_VALUE, i = -1, j = -1;
        while (p1 < p2) {
            int m1 = durations[p1];
            int m2 = durations[p2];
            if (m1 + m2 > target) {
                p2--;
            } else {
                if (m1 + m2 > max) {
                    // discard previous canidates
                    max = m1 + m2;
                    i = m1;
                    j = m2;
                }
                p1++;
            }
        }
        // check if it is possible
        if (i == -1)
            return new int[2];
        int index1 = map.get(i).get(0);
        int index2 = map.get(j).get(0);
        return new int[] { index1, index2 };
    }

    public int shopOptions(int[] A, int[] B, int[] C, int[] D, int budget) {
        // if we use TreeMap, time complexity is O(N^2 * logN), or we can use list to
        // store sum and sort the list
        // edge cases:
        if (budget == 0)
            return 0;
        int count = 0;
        Map<Integer, Integer> group1 = new TreeMap<>(); // store the freq of all possible sum
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                if (sum <= budget) {
                    group1.put(sum, group1.getOrDefault(sum, 0) + 1);
                }
            }
        }

        Map<Integer, Integer> group2 = new TreeMap<>();
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                if (sum <= budget) {
                    group2.put(sum, group2.getOrDefault(sum, 0) + 1);
                }
            }
        }
        // question becomes find two paris from two arrays

        for (int key1 : group1.keySet()) {
            for (int key2 : group2.keySet()) {
                if (key1 + key2 <= budget) {
                    count += group1.get(key1) * group2.get(key2);
                } else {// since it is sorted,
                    break;
                }
            }
        }
        return count;

    }

    public int demolitionRobot(int[][] lot) {
        // 1 is good, 9 is target, and 0 cannot be accessed
        // bfs

        // edge cases:
        if (lot[0][0] == 9)
            return 0;
        if (lot[0][0] == 0)
            return -1;

        int[][] offsets = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int m = lot.length, n = lot[0].length;
        Queue<int[]> queue = new LinkedList<>();// queue of avaiable cells
        int[][] visited = new int[m][n];
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = 1;
        int distance = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            distance++;
            for (int j = 0; j < levelSize; j++) {
                int[] cur = queue.poll();
                // now we have 4 options
                for (int i = 0; i < 4; i++) {
                    int r = cur[0] + offsets[i][0];
                    int c = cur[1] + offsets[i][1];
                    if (r < 0 || r >= m || c < 0 || c >= n)
                        continue;
                    if (lot[r][c] == 9) {
                        return distance;
                    }
                    if (visited[r][c] != 1 && lot[r][c] != 0) {
                        visited[r][c] = 1;
                        queue.offer(new int[] { r, c });
                    }
                }
            }

        }

        return -1;
    }

    public int storageOptimization(int n, int m, int[] h, int[] v) {
        // maxWidth * maxLength

        // find the max width
        int maxWidth = 0, width = 1;
        for (int i = 0; i < v.length; i++) {
            if (i - 1 >= 0 && v[i - 1] + 1 == v[i]) {
                width++;
            } else {
                width = 1;
            }
            maxWidth = Math.max(maxWidth, width);
        }
        maxWidth++;
        int maxHeight = 0, height = 1;
        for (int i = 0; i < h.length; i++) {
            if (i - 1 >= 0 && h[i - 1] + 1 == h[i]) {
                height++;
            } else {
                height = 1;
            }
            maxHeight = Math.max(maxHeight, height);
        }
        maxHeight++;
        return maxWidth * maxHeight;
    }

    public static void main(String[] args) {
        AmazonOA solution = new AmazonOA();

        /*
         * Integer[] arr = new Integer[] { 6, 4 }; List<Integer> inventory =
         * Arrays.asList(arr); int ans = solution.findHighestProfit(inventory, 4);
         * System.out.println(ans);
         */

        int[][] a = new int[][] { { 4, 10 }, { 2, 5 }, { 3, 7 }, { 1, 3 } };
        int[][] b = new int[][] { { 2, 3 }, { 4, 5 }, { 1, 2 }, { 3, 4 } };
        int target = 10;
        List<int[]> ans = solution.optimalUtilization(a, b, target);
        for (int[] e : ans) {
            System.out.print(Arrays.toString(e));
        }

        /*
         * int[][] connections = new int[][] { { 2, 6 }, { 3, 5 }, { 0, 1 }, { 2, 9 }, {
         * 5, 6 } }; int n = 10; int ans = solution.costEvaluation(n, connections);
         * System.out.println(ans);
         */

        /*
         * int d = 250; int[] ans = solution.moviesOnFlight(durations, d);
         * System.out.println(Arrays.toString(ans));
         */

        /*
         * int[] A = new int[] { 4 }; int[] B = new int[] { 2, 3 }; int[] C = new int[]
         * { 2, 3 }; int[] D = new int[] { 2, 1 }; int ans = solution.shopOptions(A, B,
         * C, D, 10); System.out.println(ans);
         */

        /*
         * int[][] lot = new int[][]{{0, 1, 1}, {1, 0, 9}, {1, 1, 1}}; int ans =
         * solution.demolitionRobot(lot); System.out.println(ans);
         */

        /*
         * int n = 6, m = 6; int[] h = new int[]{1, 3, 4}; int[] v = new int[]{2, 3};
         * int ans = solution.storageOptimization(n, m, h, v); System.out.println(ans);
         */
    }

}
