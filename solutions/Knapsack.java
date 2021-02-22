import java.util.Arrays;

public class Knapsack {

    int[][] memo;
    public static void main(String[] args){
        Knapsack knapsack = new Knapsack();
        int [] val = new int[]{1, 2, 3};
        int [] wt = new int[]{4, 5, 1};
        int W = 4;
        int res;
        Printer.print("solve problem by naive");
        res = knapsack.naive(val, wt, W, val.length - 1);
        System.out.println(res);

        Printer.print("solve problem by DP iterative");
        res = knapsack.dpIterate(val, wt, W );
        System.out.println(res);

        Printer.print("solve problem by DP Recursive");
        res = knapsack.dpRecursive(val, wt, W);
        System.out.println(res);

    }
    
    /* 
    given two integer arrays val[0..n-1] and wt[0..n-1], find the maximum value sum of subset of 
    val[] such that sum of the weight of this subset no larger than W, 1<= wt[i]<= 1000, 1<= val[i]<=1000
    */
    int ans_01;
    public int dpIterate(int [] val, int[] wt, int W){
        int [][] dp = new int[wt.length][W + 1];
         for(int i = 0; i < wt.length; i++){
             for(int sum = 1; sum <=W; sum++){
                if(i == 0) {
                     dp[i][sum] = wt[i] <= sum ? val[i] : 0;
                }else if(wt[i] <= sum){//   
                      dp[i][sum] = Math.max(dp[i - 1][sum], val[i] + dp[i-1][sum - wt[i]]);
                }else{
                      dp[i][sum] = dp[i - 1][sum];
                }
             }
         }
         return dp[val.length - 1][W];
    }

    // find elements in val from index 0 to n(inclusive) so that sum of those elments are max 
    // while total weight of elements <= weight
    public int naive(int [] val, int[] wt, int weight, int n){
        // since wt[i]>=1
        if(weight == 0){
            return 0;
        }
        if(n == 0){
            return wt[n] <= weight ? val[n] : 0;
        }else if(wt[n] > weight){
            return naive(val, wt, weight, n - 1);
        }else{
            // include current element wt[n], in order to make current total weight <= weight
            int case1 = naive(val, wt, weight - wt[n], n - 1) + val[n];
            // do not pick up the current element
            int case2 = naive(val, wt, weight, n - 1);
            return Math.max(case1, case2);
        }
    }

    // recursive with dp:
    public int dpRecursive(int [] val, int[] wt, int weight){
        memo = new int[val.length][weight + 1];
        for(int[] row : memo){
            Arrays.fill(row, Integer.MIN_VALUE);

        }
        return helper(val, wt, weight, val.length - 1);
    }


    public int helper(int [] val, int[] wt, int weight, int n){
        if(memo[n][weight] != Integer.MIN_VALUE) return memo[n][weight];
        if(weight == 0) return 0;
        if(n == 0){
            return wt[n] <= weight ? val[n] : 0;
        }else if(wt[n] > weight){
            return helper(val, wt, weight, n - 1);
        }else{
            // include current element wt[n], in order to make current total weight <= weight
            int case1 = helper(val, wt, weight - wt[n], n - 1) + val[n];
            // do not pick up the current element
            int case2 = helper(val, wt, weight, n - 1);
            memo[n][weight] = Math.max(case1, case2);
        }
        return memo[n][weight];
    }
    


}
