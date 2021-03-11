import java.io.*;
import java.util.*;

public class ClimbStairsWithMinMoves {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        
        // System.out.println(csm(arr, 0));
        int[] dp = new int[n];
        // System.out.println(csmM(arr, 0, dp));
        // System.out.println(csmt(arr));
        System.out.println(csGreedy(arr));
    }
    
    
    // recursion
    public static int csm(int[] arr, int idx) {
        if(idx == arr.length - 1) {
            return 0;
        }
        if(idx >= arr.length) {
            return Integer.MAX_VALUE - 1;
        }
        int min = Integer.MAX_VALUE - 1;
        for(int jump = 1; jump <= arr[idx]; jump++) {
            min = Math.min(min, csm(arr, idx + jump));
        }
        
        return min + 1;
    }
    
    // memoization
    public static int csmM(int[] arr, int idx, int[] dp) {
        if(idx == arr.length - 1) {
            return 0;
        }
        if(idx >= arr.length) {
            return Integer.MAX_VALUE - 1;
        }
        if(dp[idx] != 0) {
            return dp[idx];
        }
        int min = Integer.MAX_VALUE - 1;
        for(int jump = 1; jump <= arr[idx]; jump++) {
            min = Math.min(min, csmM(arr, idx + jump, dp));
        }
        dp[idx] = min + 1;
        
        return min + 1;
    }
    
    //tabulation ==> O(n^2)
    public static int csmt(int[] arr) {
        int[] dp = new int[arr.length];
        int n = arr.length;
        dp[n - 1] = 0;
        
        for(int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE - 1;
            for(int jump =1 ; jump <= arr[i]; jump++ ) {
                if(i + jump <= arr.length - 1) {
                    min = Math.min(min, dp[i+ jump]) ;
                }
            }
            dp[i] = min + 1;
        }
        
        return dp[0];
    }

    // greeedy
    public static int csGreedy(int[] arr) {
        int i = 0;
        int steps = 0;
        
        while(true) {
            if(arr[i] == 0) {
                break;
            }
            int max = -1;
            int idx = -1;
            for(int jump = 1; jump <= arr[i];jump++ )
            {
                if(i + jump == arr.length - 1) {
                    steps++;
                    return steps;
                }
                if(i + jump + arr[i + jump] >= max) {
                    max = i + jump + arr[i + jump];
                    idx = i + jump;
                }
                
            }
            i = idx;
            steps++;
        }
        return -1;
    }

}