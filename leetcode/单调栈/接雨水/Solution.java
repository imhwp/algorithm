package leetcode.单调栈.接雨水;

import java.util.Stack;

public class Solution {

    public int maxWater(int[] nums){
        int res = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                //递减栈，发现一个高于最小值的柱子，需要计算
                int cur = stack.pop();
                int curHeight = nums[cur];
                if(stack.isEmpty()) break;
                int pre = stack.peek();
                int preHeight = nums[pre];
                int area = (i-pre-1)*(Math.min(preHeight,nums[i])-curHeight);
                res+=area;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,2,0,3,2,5};
        System.out.println(solution.maxWater(nums));
    }
}
