import java.io.*;
import java.util.*;

public class CoinChangeCombinations {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] denoms = new int[n];
        for(int i = 0; i < denoms.length; i++) {
            denoms[i] = scan.nextInt();
        }
        int amt = scan.nextInt();
        
        
        // System.out.println(ccc(denoms, 0, amt));
        int[][] dp = new int[n][amt + 1];
        // System.out.println(cccM(denoms, 0, amt, dp));
        System.out.println(cccT(denoms, amt));
    }
    
    // recursion
    public static int ccc(int[] denoms, int idx, int amt) {
        if(amt == 0) return 1;
        if(amt < 0 ) return 0;
        
        if(idx == denoms.length) {
            if(amt == 0 ) return 1;
            else return 0;
        }
        
        int inc = ccc(denoms, idx, amt - denoms[idx]);
        int exc = ccc(denoms, idx + 1, amt);
        
        return (inc + exc);
    }
    
    // memoization
    public static int cccM(int[] denoms, int idx, int amt, int[][] dp) {
        if(amt == 0) return 1;
        if(amt < 0 ) return 0;
        
        if(idx == denoms.length) {
            if(amt == 0 ) return 1;
            else return 0;
        }
        if(dp[idx][amt] != 0) {
            return dp[idx][amt];
        }
        int inc = cccM(denoms, idx, amt - denoms[idx], dp);
        int exc = cccM(denoms, idx + 1, amt, dp);
        
        dp[idx][amt] = inc + exc;
        return (inc + exc);
    }
    
    // tabulation via 1D dp
    public static int cccT(int[] denoms, int amt) {
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        
        for(int i = 0; i < denoms.length; i++) {
            int tar = denoms[i];
            for(int j = denoms[i]; j <= amt; j++) {
                dp[j] += dp[j - tar];
            }
        }
        return dp[amt];
    }
}