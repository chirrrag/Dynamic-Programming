
import java.io.*;
import java.util.*;

public class CoinChangePermutation {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] denoms = new int[n];
        for(int i = 0; i < denoms.length; i++) {
            denoms[i] = scan.nextInt();
        }
        int amt = scan.nextInt();
        
        // System.out.println(ccpT(denoms, amt));
        System.out.println(ccp(denoms, amt));
    }
    
    // recusrion
    public static int ccp(int[] denoms, int amt) {
        if(amt == 0) return 1;
        if(amt < 0) return 0;
        int ans = 0;
        for(int i = 0; i < denoms.length; i++) {
            ans += ccp(denoms, amt - denoms[i]);
        }
        return ans;
    }
    
    
    // 1D tabulation
    public static int ccpT(int[] denoms, int amt) {
        int[] dp = new int[amt + 1];
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < denoms.length; j++) {
                if(i - denoms[j] >= 0){
                    dp[i] += dp[i - denoms[j]];
                }
            }
        }
        return dp[amt];
    }
}