package leetcode.复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<String> res = new ArrayList<>();
    public static void ipSolution(String s){
        //回溯+剪枝算法
        //一些前提条件
        //每个ip段最大只有255，不能有前导0
        dfs(s,0,0,new String[4]);
        for (String ss : res){
            System.out.println(ss);
        }
    }

    public static void dfs(String s,int index,int segmentIndex,String[] segment){
        if(index==s.length() && segmentIndex==4){
            StringBuilder sb = new StringBuilder();
            for (String str:segment){
                sb.append(str).append(".");
            }
            res.add(sb.substring(0,sb.length()-1));
            return;
        }
        if((s.length()-index>(4-segmentIndex)*3) || s.length()-index<4-segmentIndex) return;
        if(s.charAt(index)=='0'){
            segment[segmentIndex]="0";
            dfs(s,index+1,segmentIndex+1,segment);
            return;
        }
        for(int i=1;i<4 && index+i<=s.length();i++){
            int temp = Integer.valueOf(s.substring(index,index+i));
            if(temp>255) break;
            System.out.println(temp);
            segment[segmentIndex]= temp+"";
            dfs(s,index+i,segmentIndex+1,segment);
        }

    }

    public static void main(String[] args) {
       String s = "101023";
       ipSolution(s);
    }
}
