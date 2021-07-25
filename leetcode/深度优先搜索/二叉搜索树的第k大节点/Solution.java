package leetcode.深度优先搜索.二叉搜索树的第k大节点;

import leetcode.二叉树.TreeNode;

public class Solution {

    int res=0;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        countTree(root);
        return res;
    }

    public void countTree(TreeNode node){
        if(node==null) return;
        countTree(node.right);
        if(k==0) return;
        if(k==1){
            res = node.val;
            return;
        }
        k--;
        countTree(node.left);
    }
}
