import java.io.*;
import java.util.*;

public class MinCostMazeTraversal {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        
        // System.out.println(mc(arr, 0, 0));
        int[][] dp = new int[n][m];
        // System.out.println(mcpM(arr, 0, 0, dp));
        System.out.println(mcpTab(arr));
    }
    // recursive
    public static int mc(int[][] arr, int sr, int sc) {
        if(sr == arr.length - 1 && sc == arr[0].length - 1) {
            return arr[sr][sc];
        } 
        if(sr >= arr.length || sc >= arr[0].length ) {
            return Integer.MAX_VALUE;
        }
        
        int rr1 = mc(arr, sr, sc + 1);
        int rr2 = mc(arr, sr + 1, sc);
        
        int ans = Math.min(rr1, rr2) + arr[sr][sc];
        return ans;
    }
    
    // memoization
    public static int mcpM(int[][] arr, int sr, int sc, int[][] dp) {
        if(sr == arr.length - 1 && sc == arr[0].length - 1) {
            return arr[sr][sc];
        } 
        if(sr >= arr.length || sc >= arr[0].length ) {
            return Integer.MAX_VALUE;
        }
        
        if(dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        
        int rr1 = mcpM(arr, sr, sc + 1, dp);
        int rr2 = mcpM(arr, sr + 1, sc, dp);
        
        int ans = Math.min(rr1, rr2) + arr[sr][sc];
        dp[sr][sc] = ans;
        return ans;
    }
    
    // tabulation
    public static int mcpTab(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        
        for(int i = arr.length - 1; i >= 0; i--) {
            for(int j = arr[0].length - 1; j >= 0; j--) {
                // last row, last col
                if(i == arr.length - 1 && j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                }
                else if(i == arr.length - 1) {
                    // last row
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                }
                else if(j == arr[0].length - 1) {
                    // last col
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                }
                else {
                    // normalize case
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + arr[i][j];
                }
            }
        }
        
        return dp[0][0];

    }
    
    

}