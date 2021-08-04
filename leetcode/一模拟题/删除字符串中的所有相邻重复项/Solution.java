package leetcode.一模拟题.删除字符串中的所有相邻重复项;

public class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        if(s==null || s.equals("") || s.length()==1) return s;
        for(int i=0;i<s.length();i++){
            if(sb.length()==0){
                sb.append(s.charAt(i));
            }else if(sb.charAt(sb.length()-1)==s.charAt(i)){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
