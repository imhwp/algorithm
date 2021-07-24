package leetcode.位运算.数组中数字出现的次数;

public class Solution {

    public int[] findNum(int[] nums){
        //除了某两个数字外，其他的数字都出现了2次，求这两个数字
        //时间O(n) 空间O(1)
        int all=0;
        for(int num:nums){
            all^=num;
        }
        int m=1;
        while ((m&all)!=m){
            m=m<<1;
        }
        int x=0;
        int y=0;
        for(int num:nums){
            if((num&m)==m){
                x^=num;
            }else{
                y^=num;
            }
        }
        return new int[]{x,y};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,10,4,1,4,3,3};
        int[] num = solution.findNum(arr);
        for(int i:num){
            System.out.println(i);
        }
    }
}
