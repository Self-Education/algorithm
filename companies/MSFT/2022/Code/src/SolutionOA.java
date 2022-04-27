import java.util.*;

public class SolutionOA {

    /*
     * 给一个字符串, 只包含A, B ,写一个函数处理这个字符‍‍‌‌‌‍‍‌‍‍‌‌‌‌‌‍‍‌‍串, 使这个字符串成为左边全是A，右边全是B， 或者整个字符串都是A
     * 或者都是B，使用delete方法。 如S＝“BAAABAB”， 应该返回2， 删除第一个出现的B与最后出现的A。但还有个要求是删除字母数需要最少
     */

    public int sortAB(String s) {
        int m = s.length();
        int[] dp = new int[m];
        dp[0] = 0;
        int countB = s.charAt(0) == 'A' ? 0 : 1;
        for (int i = 1; i < m; i++) {
            if (s.charAt(i) == 'A') {
                dp[i] = Math.min(countB, 1 + dp[i - 1]);
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, i - countB);
            }
        }
        return dp[m - 1];
    }

    /*
     * 2. 给出两个数组A和B，找出index可以使得 A[i] 左边的sum 等于 B[i]左边的sum，同时A[i] 右边的sum 也等于 B[i]右边的sum。举个栗子， A: [2,
     * 7, -2, 5], B：[-1, 10, 1, 3]，在index = 3的时候， 2 + 7 = -1 + 10，同时 -2 + 5 = 1 + 3
     */
    public int partitionAtK(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int sumA = 0, sumB = 0;
        for (int a : A)
            sumA += a;
        for (int b : B)
            sumB += b;
        int curA = 0, curB = 0, count = 0;
        for (int i = 0; i < Math.min(m, n) - 1; i++) {
            curA += A[i];
            curB += B[i];
            if (curA == curB && curA == sumA - curA && curB == sumB - curB) {
                count++;
            }
        }
        return count;
    }


    /*
     * given a number including at least one 5, we can at most remove one 5 return the max number
     * after remove 5
     */
    public int remove5(int num) {
        String s = Integer.toString(num);
        int m = s.length();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '5') {
                ans = Math.max(ans, Integer.parseInt(s.substring(0, i) + s.substring(i + 1)));
            }
        }
        return ans;
    }

    /*
     * Given N numbers on a circle, described by an array A, find the maximum number of neighboring
     * pairs whose sums are even, one element can belong to only onen pair
     */
    public int evenPairs(int[] A) {
        int m = A.length;
        int[] dp1 = new int[m];
        // start and end cannot form pair
        dp1[m - 1] = 0;
        for (int i = m - 2; i >= 0; i--) {
            if ((A[i] + A[i + 1]) % 2 == 0) {
                dp1[i] = (i + 2 >= m ? 0 : dp1[i + 2]) + 1;
            } else {
                dp1[i] = dp1[i + 1];
            }
        }
        int[] dp2 = new int[m];
        dp2[m - 1] = (A[0] + A[m - 1]) % 2 == 0 ? 1 : 0;
        for (int i = m - 2; i >= 1; i--) {
            if ((A[i] + A[i + 1]) % 2 == 0) {
                dp2[i] = (i + 2 >= m ? 0 : dp2[i + 2]) + 1;
            } else {
                dp2[i] = dp2[i + 1];
            }
        }

        return Math.max(dp2[1], dp1[0]);
    }
}
/*
 * x x x x x x x x x x
 * 
 * 
 */
