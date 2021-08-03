package leetcode.数组.范围合并;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(x,y)->(x[0]-y[0]));
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=right && intervals[i][1]>=left){
                //有重叠情况
                left=Math.min(intervals[i][0],left);
                right=Math.max(intervals[i][1],right);
            }else{
                //无重叠情况
                res.add(new int[]{left,right});
                left=intervals[i][0];
                right=intervals[i][1];

            }
        }
        res.add(new int[]{left,right});
        int[][] arr = new int[res.size()][2];
        for(int i=0;i<arr.length;i++){
            arr[i]=res.get(i);
        }
        return arr;
    }
}
