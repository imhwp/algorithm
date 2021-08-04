package leetcode.一模拟题.根据字符出现的次数排序;

import java.nio.charset.CharacterCodingException;
import java.util.*;

public class Solution {
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i),count+1);
        }
        //循环结束以后，开始排序
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(x,y)->(y.getValue()-x.getValue()));
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry:list){
            for(int i=1;i<=entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="tree";
        System.out.println(frequencySort(s));
    }
}
