package leetcode.一模拟题.螺旋矩阵2;

class Solution {
    public int[][] generateMatrix(int n) {
        //定义上下左右的边界，然后按照从左到右-从上到下-从右到左-从下到上的顺序进行循环
        int l=0,r=n-1,t=0,b=n-1;
        int[][] matrix = new int[n][n];
        int num=1;
        while (num<=n*n){
            for(int i=l;i<=r;i++) matrix[t][i]=num++;
            t++;
            for(int i=t;i<=b;i++) matrix[i][r]=num++;
            r--;
            for(int i=r;i>=l;i--) matrix[b][i]=num++;
            b--;
            for(int i=b;i>=t;i--) matrix[i][l]=num++;
            l++;
        }
        return matrix;
    }
}
