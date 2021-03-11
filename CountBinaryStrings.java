import java.io.*;
import java.util.*;

public class CountBinaryStrings{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    
    
    // System.out.println(cbs(n));
    System.out.println(cbsF(n));
 }
 
 // tabulation
 public static int cbs(int n) {
     int[] dp0 = new int[n + 1]; // string ending with 0
     int[] dp1 = new int[n + 1]; // string ending with 1
     
     dp0[1] = dp1[1] = 1;
     
     for(int i = 2; i < dp0.length; i++) {
         dp0[i] = dp1[i - 1];
         dp1[i] = dp0[i - 1] + dp1[i - 1];
     }
     return dp0[n] + dp1[n];
 }
 
 // tabulation fibonacci
 public static int cbsF(int n) {
     int[] dp = new int[n + 1];
    //  dp[0] = 1;
     dp[1] = 2;
     dp[2] = 3;
     for(int i = 3; i < dp.length; i++) {
         
         dp[i] = dp[i - 1] + dp[i - 2];
     }
     return dp[n];
 }

}