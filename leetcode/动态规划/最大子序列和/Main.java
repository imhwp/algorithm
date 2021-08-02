package leetcode.动态规划.最大子序列和;

public class Main {
    public int maxSubArray(int[] nums){
        //考虑DP
        //dp[i]表示以i结尾的最大连续子数组的和
        //dp[i] = max(dp[i-1]+nums[i],nums[i])
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(main.maxSubArray(nums));
    }
}
