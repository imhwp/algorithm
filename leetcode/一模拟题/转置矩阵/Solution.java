package leetcode.一模拟题.转置矩阵;

class Solution {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int[][] B = new int[column][row];
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                B[i][j] = A[j][i];
            }
        }
        return B;
    }
}