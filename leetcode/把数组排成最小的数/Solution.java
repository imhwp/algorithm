package leetcode.把数组排成最小的数;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int minArr(int[] nums){
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = (o1 + o2).compareTo(o2 + o1);
                return i;

            }
        });
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str);
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        int[] arr = {10,2};
        Solution solution = new Solution();
        System.out.println(solution.minArr(arr));
    }
}
