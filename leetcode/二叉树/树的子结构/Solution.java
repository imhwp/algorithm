package leetcode.二叉树.树的子结构;

import leetcode.二叉树.TreeNode;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B, boolean hasMatched) {
        if(B==null || A==null) return false;
        if(A.val == B.val){
            boolean left = B.left==null?true:isSubStructure(A.left,B.left,true);
            boolean right= B.right==null?true:isSubStructure(A.right,B.right,true);
            if(left && right) return true;
        }
        if(hasMatched) return false;
        return isSubStructure(A.left,B,false) || isSubStructure(A.right,B,false);
    }
}
