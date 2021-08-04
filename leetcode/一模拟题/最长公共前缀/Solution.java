package leetcode.一模拟题.最长公共前缀;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        //先找出两个字符串的公共前缀
        //可以得到，全数组中的任意前缀长度不会超过两个前缀的长度
        //然后遍历其他的数组，如果发现当前公共前缀比之前的还短 则替换
        if(strs==null || strs.length==0) return null;
        String common = strs[0];
        int commonLen = common.length();
        for(int i=1;i<strs.length;i++){
            for(int j=0;j<commonLen;j++){
                if(common.charAt(j)!=strs[i].charAt(j)){
                    //两者不相等
                    commonLen=j;
                    break;
                }
            }
        }
        if(commonLen==0) return "";
        return common.substring(0,commonLen);
    }
}
