package leetcode.背包问题.OI背包.分割等和子集;

/**
 * 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 思路：
 *      将数组求和，得到总值SUM，该值的一半为 SUM/2-->W;
 *      现在问题转换为，从数组中取任意个数，使得总价值为W
 *      dp[i][j]表示从前i个数中挑选任意个数，使得总价值为j
 *      dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i]]
 */
public class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2==1) return false;
        boolean[]dp = new boolean[sum/2+1];
        if(nums[0]<=sum/2)
            dp[nums[0]] = true;
        for(int i=1;i<nums.length;i++){
            for(int j=sum/2;j>=nums[i];j--){
                if(dp[sum/2]) return true;
                dp[j]=dp[j]||dp[j-nums[i]];
            }
        }
        return dp[sum/2];
    }
}
