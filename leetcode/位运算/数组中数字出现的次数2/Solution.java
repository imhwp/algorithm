package leetcode.位运算.数组中数字出现的次数2;

public class Solution {
    public int findNum(int[] nums){
        int m=1;
        int res=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int num:nums){
                if((num&m)==m){
                    count++;
                }
            }
            if(count%3!=0)
            res+=(1<<i);
            m<<=1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,4,3,3};
        System.out.println(solution.findNum(arr));
    }
}
