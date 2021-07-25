package leetcode.单调栈.二叉搜索树的后序遍历序列;

import java.util.Stack;

public class Solution {
    public boolean validPostOrder(int[] postOrder){
        /**
         * 本题主要求二叉搜索树 某个节点的父节点
         */
        //先考虑清楚用递增栈还是递减栈
        //应该是递增栈
        Stack<Integer> stack = new Stack();
        int root = Integer.MAX_VALUE;
        for(int i=postOrder.length-1;i>=0;i--){
            /**
             * 三个前提
             * 1.两个数如果arr[i]<arr[i+1]，那么arr[i+1]一定是arr[i]的右孩子
             * 2.如果arr[i]>arr[i+1]，那么arr[i+1]一定是arr[0]……arr[i]中某个节点的左孩子，并且这个值是大于arr[i+1]中最小
             * 3.递增栈
             * 当遇到一个值a小于栈顶值时，需要找到该值的父节点b(即栈内最早压栈的且大于该值的值)
             * 找到该值b以后作为parent值,a为b的左孩子
             * 后续再遇到值x，有如下情况：
             *   1.它是栈内某个值的左孩子，那么该值肯定小于等于栈顶值a，(递增栈，栈顶最大)
             *   2.它是栈顶值a的右孩子,但是a是b的左孩子，因此它的孩子值也不能大于b
             * 这就是为什么该值X无论如何也不能大于b的原因。
             */
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
