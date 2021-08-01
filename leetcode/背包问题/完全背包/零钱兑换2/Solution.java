package leetcode.背包问题.完全背包.零钱兑换2;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。 
 *
 * 题目数据保证结果符合 32 位带符号整数。

 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        /**
         * dp[i] = sum(dp[i-coins[x]])
         */
        dp[0]=1;
        for(int j=0;j<coins.length;j++){
            for(int i=1;i<amount+1;i++){
                if(i-coins[j]>=0){
                    dp[i]+=dp[i-coins[j]];
                }

            }
        }
        return dp[amount];
    }

}
