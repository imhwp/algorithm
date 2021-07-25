package leetcode.二叉树.二叉搜索树与双向链表;

import leetcode.二叉树.TreeNode;

class Solution {
    TreeNode pre,head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        inOrder(root);
        //循环结束以后，pre到达了链表的末尾，还需要与头节点链接
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        if(pre==null){
            //表明是链表的第一个节点
            head = node;
        }else{
            pre.right = node;
            node.left = pre;
        }
        pre = node;
        inOrder(node.right);
    }
}