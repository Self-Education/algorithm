import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EulerianPathDetect {
    int[] in;
    int[] out;
    int edgeCounts;

    EulerianPathDetect() {

    }

    public List<Integer> detectEulerian(List<List<Integer>> graph, int n) {
        List<Integer> path = new LinkedList<>();
        // check if eulerian path exists
        in = new int[n];
        out = new int[n];

        edgeCounts = 0;

        for (int i = 0; i < n; i++) {
            out[i] += graph.get(i).size();
            for (int dest : graph.get(i)) {
                in[dest]++;
                edgeCounts++;
            }
        }

        if (ifExists(graph, n) == 1) {
            System.out.println("Eulerian Path!");
        } else if (ifExists(graph, n) == 2) {
            System.out.println("Eulerian Circuit!");
        }
        if (ifExists(graph, n) == 0)
            return path;

        // choose start and end point
        int start = findStart(graph, n);
        // find the path
        findPath(graph, path, n, start);
        Collections.reverse(path);
        if (path.size() != edgeCounts + 1)
            return null;
        return path;
    }

    // 0: no eulerian, 1: path, 2 circuit
    private int ifExists(List<List<Integer>> graph, int n) {

        if (edgeCounts == 0)
            return 2;
        // check if at most one indegree - outdegree == 1 or outdegree - indegree == 1
        int count1 = 0, count2 = 0;

        for (int i = 0; i < n; i++) {
            if (in[i] - out[i] > 1 || out[i] - in[i] > 1)
                return 0;
            if (in[i] - out[i] == 1)
                count1++;
            if (out[i] - in[i] == 1)
                count2++;
           
        }
        if (count1 == 0 && count2 == 0) {
            return 2;
        }else if(count1 <= 1 && count2 <= 1){
            return 1;
        }else{
            return 0;
        }
    }

    private int findStart(List<List<Integer>> graph, int n) {
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (out[i] - in[i] == 1) {
                return i;
            }
            if (out[i] > 0)
                start = i;
        }
        return start;
    }

    private void findPath(List<List<Integer>> graph, List<Integer> path, int n, int cur) {

        while (out[cur] != 0) {
            int next = graph.get(cur).get(--out[cur]);
            findPath(graph, path, n, next);
        }
        path.add(cur);
    }

    public static List<List<Integer>> initializeEmptyGraph(int n) {
        List<List<Integer>> graph = new LinkedList<>();
        for (int i = 0; i < n; i++)
            graph.add(new LinkedList<>());
        return graph;
    }

    public static void addDirectedEdge(List<List<Integer>> g, int from, int to) {
        g.get(from).add(to);
    }

    public static void main(String[] args) {
        EulerianPathDetect solution = new EulerianPathDetect();
        String[] arr1 = { "ijk", "kji", "abc", "cba" };
        List<List<Integer>> graph = initializeEmptyGraph(26);

        for (String s : arr1) {
            addDirectedEdge(graph, s.charAt(0) - 'a', s.charAt(s.length() - 1) - 'a');
        }
        List<Integer> path = solution.detectEulerian(graph, 26);
        System.out.println(path != null ? path.toString() : "not single connected graph");
    }
}
