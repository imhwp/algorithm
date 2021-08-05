package leetcode.一模拟题.检查区域内所有整数是否被覆盖;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges,(arr1,arr2)->{if(arr1[0]!=arr2[0]) return arr1[0]-arr2[0];return arr1[1]-arr2[1];});
        for(int[] arr:ranges){
            if(arr[0]<=left && arr[1]>=left){
                left=arr[1]+1;
            }
        }
        return left>right;
    }
}
