import java.io.*;
import java.util.*;

public class ArrangeBuildings {

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    
    System.out.println(ab(n));
 }
 
 // tabulation
 public static int ab(int n) {
     long[] dp1 = new long[n + 1]; // ending with space
     long[] dp2 = new long[n + 2];
     dp1[1] = 1;
     dp1[1] = 1;
     for(int i = 2; i < dp1.length; i++) {
        dp1[i] = dp2[i - 1];
        dp2[i] = dp1[i - 1] + dp2[i - 1];
     }
     
     long ans =  dp1[n] + dp2[n];
     return ans * ans;
     
 }

}