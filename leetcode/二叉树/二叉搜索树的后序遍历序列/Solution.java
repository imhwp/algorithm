package leetcode.二叉树.二叉搜索树的后序遍历序列;

import java.util.Stack;

public class Solution {
    public boolean validPostOrder(int[] postOrder){
        //先考虑清楚用递增栈还是递减栈
        //应该是递增栈
        Stack<Integer> stack = new Stack();
        int root = Integer.MAX_VALUE;
        for(int i=postOrder.length-1;i>=0;i--){
            if(postOrder[i]>root) return false;
            while (!stack.isEmpty() && postOrder[i]<stack.peek()){
                root = stack.pop();
            }
            stack.push(postOrder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,2,6,5};
        System.out.println(solution.validPostOrder(nums));
    }
}
