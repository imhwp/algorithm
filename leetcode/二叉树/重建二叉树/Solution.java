package leetcode.二叉树.重建二叉树;

import sun.reflect.generics.tree.Tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public TreeNode buildTree(int[] preOrder,int[] inOrder){
        return recurBuild(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }

    public TreeNode recurBuild(int[] preOrder,int preLeft,int preRight,int[] inOrder,int inLeft,int inRight){
        if(preLeft>preRight) return null;
        TreeNode root = new TreeNode(preOrder[preLeft]);
        if(preLeft==preRight){
            return root;
        }
        int rootVal = preOrder[preLeft];
        //在中序遍历中，定位到左子树和右子树的分界
        int mid = 0;
        for(int i=inLeft;i<=inRight;i++){
            if(inOrder[i]==rootVal){
                //表示匹配到了根节点
                mid = i;
            }
        }
        int leftLen = mid-inLeft;//左子树的长度
        int rightLen = inRight-mid;//右子树长度
        root.left=recurBuild(preOrder,preLeft+1,preLeft+leftLen,inOrder,inLeft,inLeft+leftLen-1);
        root.right=recurBuild(preOrder,preRight-rightLen+1,preRight,inOrder,inRight-rightLen+1,inRight);
        return root;
    }
}


