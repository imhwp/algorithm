package leetcode.二叉树.序列化二叉树;

import leetcode.二叉树.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //序列化成字符串时，对非完全二叉树的部分要补上null
        //广度优先遍历
        if(root==null) return null;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                sb.append("null");
            }else{
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val);
            }
            sb.append(",");
        }
        return sb.substring(0,sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //从字符串中解码
        // [1,2,3,null,null,4,5]
        //对于上述的字符串，首先初始化成数组
        if(data==null || data=="") return null;
        String[] strArr = data.split(",");
        // 1,2,3,null,null,4,5
        // 0,1,2,3   ,4   ,5,6
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strArr[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                if(!strArr[index].equals("null")){
                    TreeNode leftNode = new TreeNode(Integer.valueOf(strArr[index]));
                    queue.offer(leftNode);
                    node.left=leftNode;
                }
                index++;
                if(!strArr[index].equals("null")){
                    TreeNode rightNode = new TreeNode(Integer.valueOf(strArr[index]));
                    queue.offer(rightNode);
                    node.right=rightNode;
                }
                index++;
                size--;
            }
        }
        return root;



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
        String serialize = solution.serialize(root);
        TreeNode node = solution.deserialize(serialize);
        System.out.println(node.val);

    }


}