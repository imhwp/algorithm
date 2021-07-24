package leetcode.单调栈.下一个更大元素I;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterNum(int[] nums,int[] subNums){
        HashMap<Integer,Integer> map= new HashMap<>();
        Stack<Integer> stack = new Stack();
        for(int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && stack.peek()< nums[i]){
                //对于栈顶元素来说，找到了第一个比它大的值
                map.put(stack.pop(),nums[i]);
            }
            stack.push(nums[i]);
        }
        int[] res = new int[subNums.length];
        for(int i=0;i<subNums.length;i++){
            res[i] = map.getOrDefault(subNums[i],-1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,4,2};
        int[] subNums = {4,1,2};
        int[] ints = solution.nextGreaterNum(nums, subNums);
        for(int i:ints){
            System.out.println(i);
        }

    }
}
