package leetcode.位运算.求1到N的和;

public class Solution {
    public int sum(int n){
        int res = 0;
        boolean x = n>1 && (res=sum(n-1))>0;
        return n+res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sum(2));
    }
}
