import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Backtracking {
   
    List<List<Integer>> ans;
    List<int[]> combinations;
    public void partyPlanner(int[] options, int n){
        ans = new ArrayList<>();
        combinations = new LinkedList<>();
        backtrack(options, new int[options.length], 0, 0, n);
        // System.out.println(ifPossible);
        System.out.println(Arrays.toString(combinations.toArray()));
    };
    
    private void backtrack(int[] options, int[] sub, int index, int cur, int target){
        if(cur == target) {
            combinations.add(sub.clone());
            return;
        }
        if(index == options.length) return;
        for(int i = index; index < options.length; i++ ){
            if(cur + options[i] > target) break;
            System.out.println(cur);
            sub[index] ++;
            backtrack(options, sub, i, cur + options[i], target);
            sub[index] --;
        }
    }

    public static void main(String[] args) {
        Backtracking solution = new Backtracking();
        int[] options = new int[]{5, 6, 7};
        int n = 18;
        solution.partyPlanner(options, n);
    }
  
}
