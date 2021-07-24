package leetcode.单调栈.柱状图中最大的矩形;

import java.util.Stack;

public class Solution {
    public int maxMatrix(int[] nums){
        int[] newNums = new int[nums.length+2];
        for(int i=0;i<nums.length;i++){
            newNums[i+1] = nums[i];
        }
        int res = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0;i<newNums.length;i++){
            while (!stack.isEmpty() && newNums[i]<newNums[stack.peek()]){
                //递增栈，出现小于栈顶元素的柱子，则栈顶对应柱子的面积可以确定
                int cur = stack.pop();
                int curHeight = newNums[cur];
                int prev=stack.peek();
                res = Math.max(res,(i-prev-1)*curHeight);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,4};
        System.out.println(solution.maxMatrix(nums));
    }
}
