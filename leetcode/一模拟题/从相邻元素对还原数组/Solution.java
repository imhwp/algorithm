package leetcode.一模拟题.从相邻元素对还原数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现
 */
public class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        if(adjacentPairs==null) return null;
        if(adjacentPairs.length==1) return adjacentPairs[0];
        Map<Integer,Integer> cnts = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] arr:adjacentPairs){
            int c1 = cnts.getOrDefault(arr[0],0)+1;
            int c2 = cnts.getOrDefault(arr[1],0)+1;
            cnts.put(arr[0],c1);
            cnts.put(arr[1],c2);
            List<Integer> list1 = map.getOrDefault(arr[0], new ArrayList<>());
            list1.add(arr[1]);
            map.put(arr[0],list1);
            List<Integer> list2 = map.getOrDefault(arr[1], new ArrayList<>());
            list2.add(arr[0]);
            map.put(arr[1],list2);
        }

        int start=0;
        for(Map.Entry<Integer,Integer> entry:cnts.entrySet()){
            if(entry.getValue()==1){
                start=entry.getKey();
            }
        }
        int[] res = new int[adjacentPairs.length+1];
        res[0]=start;
        res[1]=map.get(start).get(0);
        for(int i=2;i<res.length;i++){
            List<Integer> nums = map.get(res[i - 1]);
            for(int num:nums){
               if(num!=res[i-2]){
                   res[i]=num;
               }
            }
        }
        return res;
    }
}
