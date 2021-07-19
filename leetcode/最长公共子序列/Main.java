package leetcode.最长公共子序列;

public class Main {

    public int lcs(String s1,String s2){
        //考虑DP做法
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //边界条件 s1的任意位置与空串的公共长度为0
        //s2的任意位置与空串的任意长度为0
        //如果 s1[i]=s2[j]，dp[i][j] = dp[i-1][j-1]+1
        //如果 s1[i]!=s2[j]，dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        Main main = new Main();
        System.out.println(main.lcs(text1, text2));
    }
}
