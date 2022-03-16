import java.util.Queue;
import java.util.LinkedList;
public class MicrosoftVO {
    

    /* 
        find kth smallest element in two sorted Array
    */
    public int kthSmallestTwoSortedArray(int[] A, int [] B, int k){
        
        if(A.length > B.length){
            int[] temp = A;
            A = B;
            B = temp;
        }
        int m = A.length, n = B.length;
        int l = 0, r = A.length;
        while(l <= r){
            int i = l + (r - l) / 2;
            int j = k - i;
            if(i > 0 && j < n && A[i - 1] > B[j]){
                r = i - 1;
            }else if(j > 0 && i < m && B[j - 1] > A[i]){
                l = i + 1;
            }else{
                //leftMax
                if(i == 0) return B[j - 1];
                if(j == 0) return A[i - 1];
                return Math.max(A[i - 1], B[j - 1]);
            }
        }

        return -1;
    }


    /* 
        minimum replacement to make a string palindrome
    */
    public int minReplacePalindrome(String s, int i, int j){
        if(i >= j) return 0;
        int res = 0;
        if(s.charAt(i) == s.charAt(j)){
            // no replacement needed
            res = minReplacePalindrome(s, i + 1, j - 1);
        }else{
            res = 1 + minReplacePalindrome(s, i + 1, j - 1);
        }
        return res;
    }
    

    /* 
        min appends to make a string palindrome
    */
    public int minAppendPalindrom(String s){
        // to find longest palindrome
        int longestPalin = longestSubstringPalindrom(s);
        return s.length() - longestPalin;
    }

    /* 
        find longest substring palindrome
    */
    public int longestSubstringPalindrom(String s){
        Boolean [][] memo = new Boolean[s.length()][s.length()];
        if(s.length() <= 1) return s.length();
        int maxLen = 1;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j < s.length(); j++){
                if(helper01(s, i, j, memo)){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    private boolean helper01(String s, int i, int j, Boolean[][] memo){
        if(i ==  j || i > j) return true;
        if(memo[i][j] != null) return memo[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return memo[i][j] = helper01(s, i + 1, j - 1, memo);
        }
        return memo[i][j] = false;
    }
    
    /* 
        Make chocolate
    */
    public int makeChocolate(int small, int big, int goal) {
        // small: 1kg, big: 5kg
        return dp(small, big, goal);
      }
      
    private int dp(int small, int big, int goal){
    if(goal == 0) return 0;
    if(goal == 6){
        System.out.println("i am here");
    }
    int res = -1;
    if(goal >= 5){
        if(big > 0){
            int next = dp(small, big - 1, goal - 5);
            res = next == -1 ? -1 : next;
        }else if(small > 0){
            int next = dp(small - 1, big, goal - 1);
            res = next == -1 ? -1 : next + 1;
        }else{
            res = -1;
        }
    }else if(goal >= 1){
        if(small > 0){
            int next = dp(small - 1, big, goal - 1);
            if(next != -1){
                res = next + 1;
            }
        }else{
            res = -1;
        }
    }
    return  res;
    }
     
    
    /* 
        root node 的值是1/1， 左侧child node 的值和parent node（a/b） 的关系是 (a+b) / b, 右侧chiled node 的值是 a/（b+a）。 问第N node 的value。


           1/1
          /    \
      2/1     1/2
      / \        / \
    3/1  2/3  3/2  1/3
    */

    public Node nNodeVal(Node node, int N){
        Queue<Node> queue = new LinkedList<>();
        int index = 0;
        queue.offer(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            index++;
            int a = cur.val1;
            int b = cur.val2;
            if(index == N){
                return cur;
            }
            queue.offer(new Node( a + b, b));
            queue.offer(new Node( a, a + b));
        }
        return null;
    }
    public static void main(String[] args){
        MicrosoftVO solution = new MicrosoftVO();
        /* int[] A = new int[]{4, 5, 6, 7, 9};
        int[] B = new int[]{1, 2};
        int k = 3;
        int ans = solution.kthSmallestTwoSortedArray(A, B, k); */

       /*  String s = "ameba";
        int ans = solution.minReplacePalindrome(s, 0, s.length() - 1); */
        /* String s = "aabb";
        int ans = solution.minAppendPalindrom(s); */

        /* int ans = solution.makeChocolate(10, 1000000, 5000006); */

        Node root = solution.new Node(1, 1);
        Node ans = solution.nNodeVal(root, 7);
        System.out.println(String.format("ans is %s / %s", ans.val1, ans.val2));
    }
    class Node{
        int val1;
        int val2;
        Node(){};
        Node(int val1, int val2){this.val1 = val1; this.val2 = val2;}
    }
}
