import java.io.*;
import java.util.*;

public class ZeroOneKnapsack {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] price = new int[n];
        for(int i = 0; i < n; i++) {
            price[i] = scan.nextInt();
        }
        int[] wt = new int[n];
        for(int i = 0; i < n; i++) {
            wt[i] = scan.nextInt();
        }
        int cap = scan.nextInt();
        // System.out.println(knapsack(price, wt, 0, cap));
        int[][] dp = new int[price.length][cap + 1];
        // System.out.println(knapsackM(price, wt, 0, cap, dp));
        System.out.println(knapsackT(price, wt, cap));
    }
    
    // recursive
    public static int knapsack(int[] price, int[] wt, int idx, int cap) {
        if(cap < 0) { 
            // overflow  condtitoni
            return Integer.MIN_VALUE;
        }
        if(idx == price.length) {
            if(cap < 0) { 
                // overflow  condtitoni
                return Integer.MIN_VALUE;
            }
            else {
                return 0;
            }
        }
        
        int rr1 = knapsack(price, wt, idx + 1, cap); // NO
        int rr2 = price[idx] +knapsack(price, wt, idx + 1, cap - wt[idx]); // yes
        
        return Math.max(rr1, rr2);
    }
    
    // memoizatoin
    public static int knapsackM(int[] price, int[] wt, int idx, int cap, int[][] dp) {
        if(cap < 0) { 
            // overflow  condtitoni
            return Integer.MIN_VALUE;
        }
        if(idx == price.length) {
            if(cap < 0) { 
                // overflow  condtitoni
                return Integer.MIN_VALUE;
            }
            else {
                return 0;
            }
        }
        if(dp[idx][cap] != 0) {
            return dp[idx][cap];
        }
        
        int rr1 = knapsackM(price, wt, idx + 1, cap, dp); // NO
        int rr2 = price[idx] +knapsackM(price, wt, idx + 1, cap - wt[idx], dp); // yes
        dp[idx][cap] = Math.max(rr1, rr2);
        return Math.max(rr1, rr2);
    }
    
    
    // tabulation
    
    public static int knapsackT(int[] price, int[] wt, int cap) {
        int[][] dp = new int[price.length + 1][cap + 1];
        // fill the fist col as  0
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // fill the first row as 0
        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                int max = dp[i - 1][j];
                if(j - wt[i - 1] >= 0) {
                    max = Math.max(max, (price[i - 1] + dp[i -1][j - wt[i - 1]]));
                }
                dp[i][j] = max;
            }
        }
        return dp[dp.length - 1][cap];
    }
    
}