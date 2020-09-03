package DP;

import java.util.Arrays;

public class MinCoinChange {
    public int minCoinDynamic(int amount, int[] coins) {
    	int dp[] = new int[amount+1];
        Arrays.fill (dp,amount+1);
        dp[0] = 0;
        Arrays.sort(coins);
        
        for (int i = 0 ; i<=amount; i++){
            
            for (int j = 0; j< coins.length;j++){
                
                   if(coins[j]<=i){
                       
                       dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                   }                
                   else{
                       break;
                   }
            }
            
            
        }
             
        return dp[amount] > amount ? -1 : dp[amount];
             

    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3 };
        int amount = 20;
        MinCoinChange m = new MinCoinChange();
        System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
                + amount + " are: " + m.minCoinDynamic(amount, coins));
    }
}
