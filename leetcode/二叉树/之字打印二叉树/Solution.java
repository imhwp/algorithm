package leetcode.二叉树.之字打印二叉树;

import leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList();
        if(root==null) return res;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            //奇数层从左往右打印
            List<Integer> subRes = new ArrayList<>();
            for(int i=deque.size();i>0;i--){
                TreeNode node = deque.removeFirst();
                if(node.left!=null) deque.addLast(node.left);
                if(node.right!=null) deque.addLast(node.right);
                subRes.add(node.val);
            }
            res.add(subRes);
            List<Integer> subRes1 = new ArrayList<>();
            for(int i=deque.size();i>0;i--){
                TreeNode node = deque.removeLast();
                if(node.left!=null) deque.addFirst(node.right);
                if(node.right!=null) deque.addFirst(node.left);
                subRes1.add(node.val);
            }
            if(subRes1.size()>0) res.add(subRes1);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rl = new TreeNode(2);
        TreeNode rr = new TreeNode(3);
        root.left=rl;
        root.right=rr;
        TreeNode rrl = new TreeNode(4);
        TreeNode rrr = new TreeNode(5);
        rr.left=rrl;
        rr.right=rrr;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists.toString());
    }
}
