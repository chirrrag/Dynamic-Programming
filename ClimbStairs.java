import java.io.*;
import java.util.*;

public class ClimbStairs {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // System.out.println(cs(n));
        
        int[] dp = new int[n + 1];
        // System.out.println(csm(n, dp));
        System.out.println(cst(n));
    }
    //recursive
    public static int cs(int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        
        int a1 = cs(n - 1);
        int a2 = cs(n - 2);
        int a3 = cs(n - 3);
        
        int ans = a1 + a2 + a3;
        return ans;
    }
    //memoization
    public static int csm(int n, int[] dp) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        int a1 = csm(n - 1, dp);
        int a2 = csm(n - 2, dp);
        int a3 = csm(n - 3, dp);
        
        int ans = a1 + a2 + a3;
        dp[n] = ans;
        return ans;
    }
    
    //tabulation
    public static int cst(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            if(i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if(i - 3 >= 0) {
                dp[i] += dp[i - 3];
            }
        }
        
        return dp[n];
    }

}
