package leetcode.动态规划.丑数;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a=0,b=0,c=0;
        for(int i=1;i<n;i++){
            dp[i] = Math.min(dp[a]*2,Math.min(dp[b]*3,dp[c]*5));
            if(dp[i]==dp[a]*2) a++;
            if(dp[i]==dp[b]*3) b++;
            if(dp[i]==dp[c]*5) c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(8));
    }
}
