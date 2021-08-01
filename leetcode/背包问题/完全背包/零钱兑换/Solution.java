package leetcode.背包问题.完全背包.零钱兑换;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i][j] 表示由前i种硬币组成的j金额的方案数
        //dp[i][j] = Math.min(dp[i-1][j-x*coins[i]) 其中x取值范围为 [0- j/coins[i]]
        int[] dp = new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            int min=amount+1;
            for(int j=0;j<coins.length;j++){

                if(i-coins[j]>=0)
                    min=Math.min(dp[i-coins[j]]+1,min);

            }
            dp[i]=min;
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
