package leetcode.背包问题.OI背包.一和零;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=strs.length;i++){
            int zeroCount = count(strs[i],'0');
            int oneCount = count(strs[i],'1');
            for(int x=m;x>=0;x--){
                for(int y=n;y>=0;y--){
                    dp[x][y] = Math.max(dp[x][y],dp[x-zeroCount][y-oneCount]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int count(String str,char target){
        int res=0;
        for(char c:str.toCharArray()){
            if(c==target) res++;
        }
        return res;
    }
}
