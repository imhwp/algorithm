package leetcode.一模拟题.最长回文子串;

public class Solution {

    public String longestPalindrome(String s) {
        //考虑动态规划
        int maxLeft = 0;
        int maxRight = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        for(int i=s.length()-2;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    if(j-i+1>maxLen){
                        maxLeft=i;
                        maxRight=j;
                        maxLen=j-i+1;
                    }
                }
            }
        }
        return s.substring(maxLeft,maxRight+1);
    }
}
