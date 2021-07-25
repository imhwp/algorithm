package leetcode.位运算.不用加减乘除做加法;

public class Solution {
    public int add(int a,int b){
        //异或运算，同则0，不同则1
        //与运算，同1则1，不同1则0
        // a = 0 1 0 0 1 = 9
        // b = 0 1 1 1 0 = 14
        //   = 1 0 1 1 1 = 23
        // & = 0 1 0 0 0
        // ^ = 0 0 1 1 1
        //&<<1+^=
        //     1 0 0 0 0 = 9
        //     0 0 1 1 1 = 14
        // sum 1 0 1 1 1 = 23
        int x=0;
        while (a!=0){
            x=a&b<<1;
            b^=a;
            a=x;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.add(1, 8));
    }
}
