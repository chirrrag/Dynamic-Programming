import java.io.*;
import java.util.*;

public class GoldMine {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        
        int[][] dp = new int[n][m];
        // int maxAns = Integer.MIN_VALUE;
        // for(int row = 0; row < n; row++) {
        //     // maxAns = Math.max(maxAns, gm(arr, row, 0));
        //     maxAns = Math.max(maxAns, gmM(arr, row, 0, dp));
        // }
        // System.out.println(maxAns);
        System.out.println(gmT(arr));
    }
    
    //recusion
    
    public static int gm(int[][] arr, int sr, int sc) {
        
        if(sr < 0  || sr >= arr.length || sc >= arr[0].length) {
            return 0;
        }
        if(sc == arr[0].length - 1) {
            return arr[sr][sc];
        }
        
        int f1 = gm(arr, sr - 1, sc + 1);
        int f2 = gm(arr, sr, sc + 1);
        int f3 = gm(arr, sr + 1, sc + 1);
        
        int ans =  arr[sr][sc] + Math.max(f1, Math.max(f2, f3)) ;
        return ans;
    }
    
    // memoization
    public static int gmM(int[][] arr, int sr, int sc, int[][] dp) {
        
        if(sr < 0  || sr >= arr.length || sc >= arr[0].length) {
            return 0;
        }
        if(sc == arr[0].length - 1) {
            return arr[sr][sc];
        }
        if(dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        
        int f1 = gmM(arr, sr - 1, sc + 1, dp);
        int f2 = gmM(arr, sr, sc + 1, dp);
        int f3 = gmM(arr, sr + 1, sc + 1, dp);
        
        int ans =  arr[sr][sc] + Math.max(f1, Math.max(f2, f3)) ;
        dp[sr][sc] = ans;
        return ans;
    }
    
    // tabulation
    public static int gmT(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for(int row = 0; row < dp.length; row++) {
            dp[row][arr[0].length - 1] = arr[row][arr[0].length - 1];
        }
        
        for(int col = dp[0].length - 2; col >= 0; col--) {
            for(int row = 0; row < dp.length; row++) {
                if(row == 0) {
                    dp[row][col] = arr[row][col] + Math.max(dp[row][col+1], dp[row + 1][col + 1]);
                }
                else if(row == dp.length - 1) {
                    dp[row][col] = arr[row][col] + Math.max(dp[row-1][col+1], dp[row][col+1]);
                }
                else {
                    dp[row][col] = arr[row][col] + Math.max(dp[row-1][col+1], Math.max(dp[row][col+1], dp[row+1][col+1]));
                }
            }
        }
        int ans = dp[0][0];
        for(int row = 1; row  < dp.length; row++) {
            ans = Math.max(ans, dp[row][0]);
        }
        return ans;
    }
    

}