package leetcode.背包问题.OI背包.目标和;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //dp[i][j] 通过前i个数，得到和为j的解决次数
        //dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
        int max = 0;
        for(int i:nums){
            max+=i;
        }
        int[][] dp = new int[nums.length][2*max+1];
        if(Math.abs(target)>max){
            return 0;
        }
        if(nums[0]==0){
            dp[0][max]=2;
        }else{
            dp[0][max-nums[0]]=1;
            dp[0][max+nums[0]]=1;
        }


        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=2*max;j++){
                //当j<max之前，j都是负数
                //当j>max，j都是正数
                if(j-nums[i]<0){
                    //所有数都变成了负数，再继续下去已经没有意义
                    dp[i][j]=dp[i-1][j+nums[i]];
                }else if(j+nums[i]>2*max){
                    //所有数都变成了正数 再继续下去没有意义
                    dp[i][j]=dp[i-1][j-nums[i]];
                }else{
                    //在这范围之内
                    dp[i][j]=dp[i-1][j-nums[i]]+dp[i-1][j+nums[i]];
                }

            }
        }
        return dp[nums.length-1][max+target];
    }
}
