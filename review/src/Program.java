import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Program {
    public static void main(String[] args) {
        Program test = new Program();
        int[][] red_edges = new int[][] { { 5, 5 }, { 4, 6 }, { 6, 4 }, { 4, 1 }, { 4, 3 }, { 2, 3 }, { 1, 1 },
                { 1, 6 }, { 0, 6 }, { 0, 2 }, { 1, 5 }, { 6, 0 } };
        int[][] blue_edges = new int[][] { { 1, 1 }, { 5, 2 }, { 4, 0 }, { 5, 5 }, { 2, 4 }, { 4, 2 }, { 0, 4 },
                { 0, 5 }, { 3, 5 }, { 1, 2 }, { 6, 2 }, { 0, 6 }, { 3, 1 }, { 5, 0 } };
        int n = 7;
        int[] res = test.shortestAlternatingPaths(n, red_edges, blue_edges);
        System.out.println(Arrays.toString(res));
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        /*
         * track the shortest dist of such path to ith node end with both red and blue
         * Node(i, j), i indicates the len of alternate color path to node end at red
         */

        Map<Integer, List<int[]>> graph = new HashMap<>(); // {node: [ [to, color] ...]}, 0: red
        for (int[] e : red_edges) {
            int from = e[0], to = e[1];
            graph.computeIfAbsent(from, x -> new LinkedList<>()).add(new int[] { to, 0 });
        }

        for (int[] e : blue_edges) {
            int from = e[0], to = e[1];
            graph.computeIfAbsent(from, x -> new LinkedList<>()).add(new int[] { to, 1 });
        }
        int[][] memo = new int[n][2]; // shortest dist to each cell end with red or blue
        for (int[] row : memo)
            Arrays.fill(row, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        memo[0][0] = 0;
        memo[0][1] = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            count++;
            for (int i = 0; i < levelSize; i++) {
                int cur = queue.poll();
                for (int[] nei : graph.getOrDefault(cur, new LinkedList<>())) {
                    int next = nei[0], color = nei[1];
                    boolean canAccess = false;
                    if (color == 0 && memo[cur][1] != -1 && memo[next][0] == -1) {
                        memo[next][0] = 1 + memo[cur][1];
                        canAccess = true;
                    }
                    if (color == 1 && memo[cur][0] != -1 && memo[next][1] == -1) {
                        memo[next][1] = 1 + memo[cur][0];
                        canAccess = true;
                    }

                    if (canAccess)
                        queue.offer(next);
                }
            }
        }
        int[] ans = new int[n];
        int p = 1;
        for (int i = 1; i < n; i++) {
            if (memo[i][0] == -1 && memo[i][1] == -1) {
                ans[p] = -1;
            } else if (memo[i][0] != -1 && memo[i][1] != -1) {// only one colr cannot be reached
                ans[p] = Math.min(memo[i][0], memo[i][1]);
            } else {
                ans[p] = Math.max(memo[i][0], memo[i][1]);
            }
            p++;
        }
        return ans;
    }
}