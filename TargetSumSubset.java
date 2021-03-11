import java.io.*;
import java.util.*;

public class TargetSumSubset {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        
        int tar = scan.nextInt();
        // System.out.println(tss(arr, 0, tar));
        boolean[][] dp = new boolean[n][tar + 1];
        // System.out.println(tssM(arr, 0, tar, dp));
        System.out.println(tssT(arr, tar));
    }
    //recursion
    public static boolean tss(int[] arr , int idx, int tar) {
        if(idx == arr.length) {
            if(tar == 0) {
                return true;
            }else {
                return false;
            }
        }
        
        boolean rr1 = tss(arr, idx + 1, tar); // NO ki call
        if(rr1 == true) {
            return true;
        }
        
        boolean rr2 = tss(arr, idx + 1, tar - arr[idx]); // YES kicall
        if(rr2 == true) {
            return true;
        }
        // jab dono false return karege, so we'll return false
        return false;
    }
    
    // memoization ==> WRONG WRONG WRONG 
    public static boolean tssM(int[] arr, int idx, int tar, boolean[][] dp) {
        if(idx == arr.length) {
            if(tar == 0) {
                return true;
            }else {
                return false;
            }
        }
        if(dp[idx][tar] == true) {
            return true;
        }
        boolean rr1 = tssM(arr, idx + 1, tar, dp); // NO ki call
        if(rr1 == true) {
            dp[idx][tar] = true;
            return true;
        }
        
        boolean rr2 = tssM(arr, idx + 1, tar - arr[idx], dp); // YES kicall
        if(rr2 == true) {
            dp[idx][tar] = true;
            return true;
        }
        // jab dono false return karege, so we'll return false
        dp[idx][tar] = false;
        return false;
    }
    
    
    // tabulation
    
    public static boolean tssT(int[] arr, int tar) {
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        
        // first col me true
        for(int row = 0; row < dp.length; row++) {
            dp[row][0] = true;
        }
        // first row me 1st idx pe automatically false stored hoga
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // no ki call
                dp[i][j] = dp[i - 1][j];
                // yes ki call tabhi lagao jab no ki call me false aaye
                if(dp[i][j] == false ){
                    if(j - arr[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j - arr[i - 1]];
                    }
                }
            }
        }
        
        return dp[dp.length - 1][tar];
    }

}