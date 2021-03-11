import java.io.*;
import java.util.*;

public class ClimbStairsWithVariableJumps {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        
        // System.out.println(cs(arr, 0));
        int[] dp = new int[n + 1];
        // System.out.println(csm(arr, 0, dp));
        System.out.println(cst(arr));
    }
    //recursive
    public static int cs(int[] arr, int idx) {
        if(idx == arr.length) {
            return 1;
        }
        if(idx > arr.length) {
            return 0;
        }
        
        int ans = 0;
        for(int i = 1; i <= arr[idx]; i++) {
            ans += cs(arr, idx + i);
        }
        return ans;
        
    }
    // memoization
    public static int csm(int[] arr, int idx, int[] dp) {
        if(idx == arr.length) {
            return 1;
        }
        if(idx > arr.length) {
            return 0;
        }
        if(dp[idx] != 0) {
            return dp[idx];
        }
        int ans = 0;
        for(int i = 1; i <= arr[idx]; i++) {
            ans += csm(arr, idx + i, dp);
        }
        dp[idx] = ans;
        return ans;
        
    }
    
    // /tabulation
    public static int cst(int[] arr) {
        int n = arr.length + 1;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            int ans = 0;
            for(int jump = 1; jump <= arr[i]; jump++) {
                if(i + jump <= arr.length ) {
                    ans += dp[i + jump];
                }
            }
            dp[i] = ans;
        }
        
        return dp[0];
    }
}