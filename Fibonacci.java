import java.io.*;
import java.util.*;

public class Fibonacci{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    
    // System.out.println(fib(n));
    int[] dp = new int[n + 1];
    System.out.println(fibT(n));
 }
 
 public static int fibM(int n, int[] dp) {
     if(n == 0 || n == 1) {
         return n;
     }
     
     if(dp[n] != 0) {
         return dp[n];
     }
     int fibnm1 = fibM(n - 1, dp);
     int fibnm2 = fibM(n - 2, dp);
     
     int ans = fibnm1 + fibnm2;
     dp[n] = ans;
     return ans;
 }
 public static int fibT(int n) {
     int[] dp = new int[n + 1];
     dp[1] = 1;
     for(int i = 2; i < dp.length; i++) {
         dp[i] = dp[i - 1 ] + dp[i - 2];
         
     }
     return dp[n];
 }
 public static int fib(int n) {
     if(n == 0 || n == 1) return n;
     
     int fibnm1 = fib(n - 1);
     int fibnm2 = fib(n - 2);
     
     int ans = fibnm1 + fibnm2;
     return ans;
 }

}