package leetcode.单调栈.下一个更大的元素2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterNum(int[] nums){
        Stack<Integer> stack = new Stack();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res,-1);
        for(int i=0;i<nums.length*2;i++){
            while (!stack.isEmpty() && nums[stack.peek()]< nums[i%len]){
                //对于栈顶元素来说，找到了第一个比它大
                int cur = stack.pop();
                res[cur] = nums[i%len];
            }
            stack.push(i%len);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,4,2};
        int[] ints = solution.nextGreaterNum(nums);
        for(int i:ints){
            System.out.println(i);
        }

    }
}
