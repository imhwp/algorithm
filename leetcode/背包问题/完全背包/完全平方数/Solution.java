package leetcode.背包问题.完全背包.完全平方数;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int min = i;
            for(int j=1; j<=(int)Math.sqrt(i);j++){
                min=Math.min(dp[i-j*j]+1,min);
            }
            dp[i]=min;
        }
        return dp[n];
    }
}
