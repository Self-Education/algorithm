import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AmazonOA {

    /*
     * find the highest profit
     */

    public int findHighestProfit(List<Integer> inventory, int order) {
        // todo edge cases:
        if (order == 0 || inventory.size() == 0)
            return 0;

        // two pointers
        int ans = 0;
        while (order > 0) {
            if (inventory.get(0) > inventory.get(1)) {
                ans += inventory.get(0);
                inventory.set(0, inventory.get(0) - 1);
            } else {
                ans += inventory.get(1);
                inventory.set(1, inventory.get(1) - 1);
            }
            order--;
        }

        return ans;
    }

    /*
     * items in containers, * | * * | * * |
     */
    public int itemInContainers1(String s, List<List<Integer>> ranges) {
        // '*'' can be the valid item only when it is enclosed by |, we need to find
        // closet | after the start
        // and the closest | before the end
        // todo edge cases:

        int m = s.length();
        int[] leftBound = new int[m];
        int[] rightBound = new int[m];

        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                left = i;
            }
            leftBound[i] = left;
        }
        int right = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                right = i;
            }
            rightBound[i] = right;
        }
        // number of * before current |
        int curSum = 0;
        int[] prefix = new int[m];
        Arrays.fill(prefix, -1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                prefix[i] = curSum;
            } else {
                curSum++;
            }
        }
        int ans = 0;
        for (List<Integer> range : ranges) {
            int start = range.get(0);
            int end = range.get(1);
            int left_bound = rightBound[start];
            int right_bound = leftBound[end];
            if (left_bound != -1 && right_bound != -1 && start < end) {
                ans += prefix[right_bound] - prefix[left_bound];
            }
        }
        return ans;
    }

    /*
     * Optimal Utilization
     */
    public List<int[]> optimalUtilization(List<int[]> a, List<int[]> b, int target) {

        // two pointers
        Collections.sort(a, (m, n) -> m[1] - n[1]);
        Collections.sort(a, (m, n) -> m[1] - n[1]);

        int p1 = 0, p2 = b.size() - 1, max = Integer.MIN_VALUE;
        List<int[]> ans = new LinkedList<>();
        while (p1 < a.size() && p2 >= 0) {
            int sum = a.get(p1)[1] + b.get(p2)[1];
            if (sum > target) {
                // move p2 toward left to lower the sum
                p2--;
            } else {// sum < target, we can move p1 to right to increase p2
                if (sum < max)
                    continue;

                if (sum > max) { // previous list with sum == max should be discarded
                    max = sum;
                    ans.clear();
                }
                ans.add(new int[] { a.get(p1)[0], b.get(p2)[0] });
                // handle duplicates
                int k = p2 - 1;
                while (k >= 0 && b.get(k)[1] == b.get(p2)[1]) {
                    ans.add(new int[] { a.get(p1)[0], a.get(k)[0] });
                }
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
    public static int waystoBuy(int[] jeans,int[] shoes,int[] skirts,int[] tops,int budget){
        List<Integer> sumJeansShoes = new ArrayList<>();
        for(int i=0;i<jeans.length;i++){
            for(int j=0;j<shoes.length;j++){
                if(jeans[i]+shoes[j]<budget)
                    sumJeansShoes.add(jeans[i]+shoes[j]);
            }
        }
        Collections.sort(sumJeansShoes);
        List<Integer> sumSkirtsTops = new ArrayList<>();
        for(int i=0;i<skirts.length;i++){
            for(int j=0;j<tops.length;j++){
                if(skirts[i]+tops[j]<budget)
                    sumSkirtsTops.add(skirts[i]+tops[j]);
            }
        }
        Collections.sort(sumSkirtsTops);
        int numways=0;
        for(int i=0;i<sumJeansShoes.size();i++){
            for(int j=0;j<sumSkirtsTops.size();j++){
                if(sumJeansShoes.get(i) + sumSkirtsTops.get(j)<=budget)
                    numways++;
                else
                    break;
            }
        }
        
            return numways;
        }

    public static void main(String[] args) {
        AmazonOA solution = new AmazonOA();
        /*
         * Integer[] arr = new Integer[] { 10, 10 }; List<Integer> inventory =
         * Arrays.asList(arr); int ans = solution.findHighestProfit(inventory, 5);
         */

        /*
         * String s = "*|**|**|"; List<List<Integer>> ranges = new LinkedList<>();
         * List<Integer> range1 = new LinkedList<>() { { add(0); add(1); } };
         * ranges.add(range1); int ans = solution.itemInContainers(s, ranges);
         */

        /*
         * int[][] arr1 = new int[][] { { 1, 8 }, { 2, 7 }, { 3, 14 } }; int[][] arr2 =
         * new int[][] { { 1, 5 }, { 2, 10 }, { 3, 14 } }; List<int[]> a = new
         * LinkedList<>(); List<int[]> b = new LinkedList<>(); for (int i = 0; i <
         * arr1.length; i++) { a.add(arr1[i]); b.add(arr2[i]); } int target = 20;
         * List<int[]> ans = solution.optimalUtilization(a, b, target); for (int[] e :
         * ans) { System.out.print(Arrays.toString(e)); }
         */

        /*
         * int[][] connections = new int[][] { { 2, 6 }, { 3, 5 }, { 0, 1 }, { 2, 9 }, {
         * 5, 6 } }; int n = 10; int ans = solution.costEvaluation(n, connections);
         * System.out.println(ans);
         */

        // int[] durations = new int[] { 250, 360, 520, 999 };
        // int d = 250;
        // int[] ans = solution.moviesOnFlight(durations, d);
        // System.out.println(Arrays.toString(ans));
    }

}
